package pl.lukasz.university.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage()
    {
        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Authentication authentication, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if(authentication != null)
        {
            new SecurityContextLogoutHandler().logout(httpServletRequest,httpServletResponse,authentication);
        }

        return "redirect:/";
    }
}
