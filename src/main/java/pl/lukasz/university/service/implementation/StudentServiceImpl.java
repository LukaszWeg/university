package pl.lukasz.university.service.implementation;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.entity.User;
import pl.lukasz.university.repository.StudentRepository;
import pl.lukasz.university.repository.UserRepository;
import pl.lukasz.university.service.RoleService;
import pl.lukasz.university.service.StudentService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;


    public StudentServiceImpl(StudentRepository studentRepository, RoleService roleService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public List<Student> findAllByIdOrderByLastnameAsc() {
        return studentRepository.findAllByOrderByLastnameAsc();
    }

    @Override
    public void checkAndSave(Student student) {
        Set<Role> role = new HashSet<>();
        role.add(roleService.findByName("Student"));
        User user = new User();
        user.setStudent(student);
        user.setUsername(student.getFirstname()+student.getLastname());
        user.setPassword(passwordEncoder.encode(student.getPESEL().toString()));
        user.setRole(role);
        userRepository.save(user);
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(!student.isPresent()) {
            throw new RuntimeException();
        }
        return student.get();
    }
}
