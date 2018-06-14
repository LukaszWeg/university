package pl.lukasz.university.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.entity.ConnectTable;
import pl.lukasz.university.service.StudentService;
import pl.lukasz.university.service.SubjectService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/mysubjects")
@Controller
public class TeacherSubjectsController {

    private SubjectService subjectService;
    private StudentService studentService;

    public TeacherSubjectsController(SubjectService subjectService, StudentService studentService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String presence(Model model, @PathVariable ("id") Long id)
    {

        model.addAttribute("students", studentService.findAllByIdOrderByLastnameAsc());
        model.addAttribute("subject", subjectService.findById(id));
        return "teacher/presenceForm";
    }

    @RequestMapping(value = "/{subjectId}/{studentId}", method = RequestMethod.GET)
    public String setPresence(Model model) {
        model.addAttribute("newPresence", new ConnectTable());
        return "teacher/setPresence";
    }


}
