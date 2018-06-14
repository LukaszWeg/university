package pl.lukasz.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.university.entity.Subject;
import pl.lukasz.university.entity.Teacher;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByOrderByDateAsc();

    List<Subject> findByTeacherOrderByDateDesc(Teacher teacher);
}
