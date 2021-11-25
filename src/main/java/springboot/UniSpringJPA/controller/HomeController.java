package springboot.UniSpringJPA.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getHomePage(){
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/student")
    public String getStudentPage() {
        return "index";
    }

    @PostMapping("/this-post-endpoint")
    public String postMethod(@ModelAttribute("studentID") Long studentID,
                             @ModelAttribute("password") String password,
                             Model model) {
        return "index";
    }
}
