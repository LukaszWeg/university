package pl.lukasz.university.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/students")
@Controller
public class StudentController {

    @RequestMapping
    public String getAllStudents()
    {
        return "nothing for now";
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
