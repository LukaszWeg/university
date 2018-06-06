package pl.lukasz.university.service.implementation;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.repository.StudentRepository;
import pl.lukasz.university.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllByIdOrderByLastnameAsc() {
        return studentRepository.findAllByOrderByLastnameAsc();
    }
}
