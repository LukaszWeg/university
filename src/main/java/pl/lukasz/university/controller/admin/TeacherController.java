package pl.lukasz.university.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.entity.Teacher;
import pl.lukasz.university.service.TeacherService;

@RequestMapping(value = "/teachers")
@Controller
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping
    public String getAllTeachers(Model model)
    {
        model.addAttribute("teachers", teacherService.findAllbyIdOrderByLastnameAsc());
        return "admin/teachers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String sendTeacher(Model model)
    {
        model.addAttribute("teacher", new Teacher());
        return "admin/teacherForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute ("teacher") Teacher teacher)
    {
        teacherService.checkAndSave(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteTeacher(@PathVariable ("id") Long id)
    {
        teacherService.delete(id);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editTeacher(@PathVariable ("id") Long id, Model model)
    {
        model.addAttribute("teacher", teacherService.findTeacherById(id));
        return "admin/teacherForm";
    }

    @RequestMapping(value = "/{id}")
    public String getTeacher(@PathVariable ("id") Long id, Model model)
    {
        model.addAttribute("teacher", teacherService.findTeacherById(id));
        return "teacher/teacher";
    }
}
