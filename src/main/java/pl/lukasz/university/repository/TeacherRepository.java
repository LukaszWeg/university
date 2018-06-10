package pl.lukasz.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.university.entity.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAllByOrderByLastnameAsc();
    Teacher findByEmail(String email);

}
