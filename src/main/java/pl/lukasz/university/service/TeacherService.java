package pl.lukasz.university.service;

import pl.lukasz.university.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllbyIdOrderByLastnameAsc();

    Teacher findTeacherById(Long id);

    void checkAndSave(Teacher teacher);

    void delete(Long id);
}
