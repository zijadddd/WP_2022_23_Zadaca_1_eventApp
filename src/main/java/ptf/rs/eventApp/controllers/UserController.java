package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.services.UserService;
import ptf.rs.eventApp.models.in.UserIn;


@Controller
public class UserController {
    
    @Autowired
    private UserService _UserService;

    @PostMapping("/banuser/{useremail}")
    public String banUser(@PathVariable String useremail) {
        _UserService.banUser(useremail);
        return "redirect:index";
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute("user") UserIn user, RedirectAttributes message) {
        _UserService.registerUser(user);
        message.addFlashAttribute("message", "Uspjesno ste se registrovali.");
        return "redirect:login";
    }
}
