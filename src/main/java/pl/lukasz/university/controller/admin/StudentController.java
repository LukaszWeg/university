package pl.lukasz.university.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.entity.Student;
import pl.lukasz.university.service.StudentService;

import javax.validation.Valid;


@RequestMapping(value = "/students")
@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.findAllByIdOrderByLastnameAsc());
        return "admin/students";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newStudent(Model model) {
        model.addAttribute("newStudent", new Student());
        return "admin/studentForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/studentForm";
        }
        studentService.checkAndSave(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editStudent(@PathVariable("id") Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("newStudent", student);
        return "admin/studentForm";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") Long id, Model model)
    {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/student";
    }
}
