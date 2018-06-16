package pl.lukasz.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.university.entity.ConnectTable;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.entity.Subject;

import java.util.List;

@Repository
public interface ConnectTableRepository extends JpaRepository<ConnectTable, Long> {


    ConnectTable findByStudentAndSubject(Student student, Subject subject);
    List<ConnectTable> findBySubject(Subject subject);
    List<ConnectTable> findByStudent(Student student);

}
