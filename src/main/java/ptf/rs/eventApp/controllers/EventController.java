package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.models.in.EventIn;
import ptf.rs.eventApp.services.EventService;

@Controller
public class EventController {
    
    @Autowired
    private EventService _EventService;

    @GetMapping("/")
    public String getAllEvents(Model model) {        
        model.addAttribute("events", _EventService.getAllEvents());
        return "index";
    }

    @PostMapping("/addevent")
    public String addNewEvent(@ModelAttribute("event") EventIn event, RedirectAttributes message) {
        _EventService.addNewEvent(event);
        message.addFlashAttribute("message", "Event successfully added.");
        return "redirect:adminpanel";
    }
    
}
