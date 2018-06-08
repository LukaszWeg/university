package pl.lukasz.university.service.implementation;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.repository.StudentRepository;
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

    public StudentServiceImpl(StudentRepository studentRepository, RoleService roleService) {
        this.studentRepository = studentRepository;
        this.roleService = roleService;
    }

    @Override
    public List<Student> findAllByIdOrderByLastnameAsc() {
        return studentRepository.findAllByOrderByLastnameAsc();
    }

    @Override
    public void checkAndSave(Student student) {
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName("Student");
        roles.add(role);
        student.setRole(role);
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
