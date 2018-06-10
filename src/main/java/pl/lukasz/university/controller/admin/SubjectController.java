package pl.lukasz.university.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.lukasz.university.service.SubjectService;
import pl.lukasz.university.service.TeacherService;

@Controller
@RequestMapping(value = "/subjects")
public class SubjectController {

    private TeacherService teacherService;
    private SubjectService subjectService;

    public SubjectController(TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @RequestMapping()
    public String getAllSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAllByOrderByDateAsc());
        return "admin/subjects";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String sendSubject(Model model){
    model.addAttribute("subject", new NewSubjectForm());
    model.addAttribute("teachers", teacherService.findAllbyIdOrderByLastnameAsc());
    return "admin/subjectForm";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute ("subject") NewSubjectForm newSubjectForm) {
        subjectService.checkAndSave(newSubjectForm);
        return "redirect:/subjects";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable("id") Long id) {
        subjectService.delete(id);
        return "redirect:/subjects";
    }
}
