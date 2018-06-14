package pl.lukasz.university.controller.teacher;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.entity.ConnectTable;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.entity.Subject;
import pl.lukasz.university.entity.Teacher;
import pl.lukasz.university.repository.ConnectTableRepository;
import pl.lukasz.university.repository.TeacherRepository;
import pl.lukasz.university.service.StudentService;
import pl.lukasz.university.service.SubjectService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/mysubjects")
@Controller
public class TeacherSubjectsController {

    private SubjectService subjectService;
    private StudentService studentService;
    private ConnectTableRepository connectTableRepository;
    private TeacherRepository teacherRepository;

    public TeacherSubjectsController(SubjectService subjectService, StudentService studentService, ConnectTableRepository connectTableRepository, TeacherRepository teacherRepository) {
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.connectTableRepository = connectTableRepository;
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping()
    public String getMySubjects(Model model, Authentication authentication) {
        Teacher teacher = teacherRepository.findByEmail(authentication.getName());
        model.addAttribute("subjects", subjectService.findByTeacherOrderByDateDesc(teacher));
        return "teacher/mysubjects";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String presence(Model model, @PathVariable ("id") Long id)
    {
        Subject subject = subjectService.findById(id);
        model.addAttribute("students", studentService.findAllByIdOrderByLastnameAsc());
        model.addAttribute("subject", subjectService.findById(id));
        model.addAttribute("presence", connectTableRepository.findBySubject(subject));
        return "teacher/presenceForm";
    }

    @RequestMapping(value = "/{subjectId}/{studentId}", method = RequestMethod.GET)
    public String setPresence(Model model,@PathVariable ("subjectId") Long subjectid, @PathVariable ("studentId") Long studentId) {
        Subject subject = subjectService.findById(subjectid);
        Student student = studentService.findById(studentId);
        ConnectTable connectTable = connectTableRepository.findByStudentAndSubject(student, subject);
        if (connectTable != null) {
            model.addAttribute("newPresence", connectTable);
        }
        else
        {
            model.addAttribute("newPresence", new ConnectTable());
        }


        return "teacher/setPresence";
    }

    @RequestMapping(value = "/{subjectId}/{studentId}", method = RequestMethod.POST)
    public String savePresence(@PathVariable ("subjectId") Long subjectid, @PathVariable ("studentId") Long studentId, @ModelAttribute ("newPresencet") ConnectTable connectTable)
    {
        Subject subject = subjectService.findById(subjectid);
        Student student = studentService.findById(studentId);
        connectTable.setStudent(student);
        connectTable.setSubject(subject);
        connectTableRepository.save(connectTable);
        return "redirect:/mysubjects/"+ subjectid;


    }


}
