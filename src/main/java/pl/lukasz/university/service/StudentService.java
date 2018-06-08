package pl.lukasz.university.service;

import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> findAllByIdOrderByLastnameAsc();

    void checkAndSave(Student student);

    void delete(Long id);

    Student findById(Long id);
}
