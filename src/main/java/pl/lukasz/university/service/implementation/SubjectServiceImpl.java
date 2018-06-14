package pl.lukasz.university.service.implementation;

import org.springframework.stereotype.Service;
import pl.lukasz.university.controller.admin.NewSubjectForm;
import pl.lukasz.university.entity.ConnectTable;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.entity.Subject;
import pl.lukasz.university.repository.SubjectRepository;
import pl.lukasz.university.repository.TeacherRepository;
import pl.lukasz.university.service.SubjectService;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void checkAndSave(NewSubjectForm newSubjectForm) {
        Subject subject = new Subject();
        subject.setAddress(newSubjectForm.getAddress());
        subject.setDate(newSubjectForm.getDate());
        subject.setLenght(newSubjectForm.getLenght());
        subject.setSubject(newSubjectForm.getSubject());
        subject.setTeacher(teacherRepository.findByEmail(newSubjectForm.getTeacherEmail()));
        subjectRepository.save(subject);
    }

    @Override
    public List<Subject> findAllByOrderByDateAsc() {
        return subjectRepository.findAllByOrderByDateAsc();
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject findById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        if(!subject.isPresent()){
            throw new RuntimeException();
        }
        return subject.get();
    }

}
