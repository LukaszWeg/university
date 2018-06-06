package pl.lukasz.university.service;

import org.springframework.stereotype.Service;
import pl.lukasz.university.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> findAllByIdOrderByLastnameAsc();
}
