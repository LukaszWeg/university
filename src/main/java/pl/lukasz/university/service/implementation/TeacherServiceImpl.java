package pl.lukasz.university.service.implementation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.entity.Teacher;
import pl.lukasz.university.entity.User;
import pl.lukasz.university.repository.RoleRepository;
import pl.lukasz.university.repository.TeacherRepository;
import pl.lukasz.university.repository.UserRepository;
import pl.lukasz.university.service.TeacherService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public List<Teacher> findAllbyIdOrderByLastnameAsc() {
        return teacherRepository.findAllByOrderByLastnameAsc();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(!teacher.isPresent())
        {
            throw new RuntimeException();
        }
        return teacher.get();
    }

    @Override
    public void checkAndSave(Teacher teacher) {
        Set<Role> role = new HashSet<>();
        role.add(roleRepository.findByName("Teacher"));
        User user = new User();
        user.setTeacher(teacher);
        user.setUsername(teacher.getEmail());
        user.setPassword(passwordEncoder.encode(teacher.getContactNumber().toString()));
        user.setRole(role);
        teacherRepository.save(teacher);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = findTeacherById(id);
        teacherRepository.delete(teacher);

    }
}
