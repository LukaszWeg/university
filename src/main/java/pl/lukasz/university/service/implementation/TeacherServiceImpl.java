package pl.lukasz.university.service.implementation;

import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Role;
import pl.lukasz.university.entity.Teacher;
import pl.lukasz.university.repository.RoleRepository;
import pl.lukasz.university.repository.TeacherRepository;
import pl.lukasz.university.service.TeacherService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private RoleRepository roleRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, RoleRepository roleRepository) {
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
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
        Role role = roleRepository.findByName("Teacher");
        teacher.setRole(role);
        teacherRepository.save(teacher);

    }

    @Override
    public void delete(Long id) {
        Teacher teacher = findTeacherById(id);
        teacherRepository.delete(teacher);

    }
}
