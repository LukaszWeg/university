package pl.lukasz.university.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.service.StudentService;

@RequestMapping(value = "/students")
@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public String getAllStudents(Model model)
    {
        model.addAttribute("students", studentService.findAllByIdOrderByLastnameAsc());
        return "admin/students";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newStudent()
    {
        return "0";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveStudent() {
        return null;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent()
    {
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudent()
    {
        return null;
    }
}
