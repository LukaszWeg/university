package pl.lukasz.university.controller.student;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.repository.ConnectTableRepository;
import pl.lukasz.university.service.StudentService;
import pl.lukasz.university.service.SubjectService;

@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private SubjectService subjectService;
    private ConnectTableRepository connectTableRepository;
    private StudentService studentService;

    public ScheduleController(SubjectService subjectService, ConnectTableRepository connectTableRepository, StudentService studentService) {
        this.subjectService = subjectService;
        this.connectTableRepository = connectTableRepository;
        this.studentService = studentService;
    }

    @RequestMapping()
    public String schedule(Model model, Authentication authentication)
        {

            Student student = studentService.findByTelephoneNumber(Long.valueOf(authentication.getName()));
            model.addAttribute("presence", connectTableRepository.findByStudent(student));
            model.addAttribute("subjects", subjectService.findAllByOrderByDateAsc());
            return "student/schedule";
        }
}
