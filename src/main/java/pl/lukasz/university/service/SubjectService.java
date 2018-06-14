package pl.lukasz.university.service;

import pl.lukasz.university.controller.admin.NewSubjectForm;
import pl.lukasz.university.entity.Subject;
import pl.lukasz.university.entity.Teacher;

import java.util.List;

public interface SubjectService {

        void checkAndSave(NewSubjectForm newSubjectForm);

        List<Subject> findAllByOrderByDateAsc();

        void delete(Long id);

        Subject findById(Long id);

        List<Subject> findByTeacherOrderByDateDesc(Teacher teacher);

}
