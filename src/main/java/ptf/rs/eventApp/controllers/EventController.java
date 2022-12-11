package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.models.in.EventIn;
import ptf.rs.eventApp.models.out.EventOut;
import ptf.rs.eventApp.services.CategoryService;
import ptf.rs.eventApp.services.EventService;
import ptf.rs.eventApp.services.LocationService;

@Controller
public class EventController {
    
    @Autowired
    private EventService _EventService;

    @Autowired
    private LocationService _LocationService;

    @Autowired
    private CategoryService _CategoryService;

    @GetMapping("/")
    public String getAllEvents(Model model) {        
        model.addAttribute("events", _EventService.getAllEvents());
        return "index";
    }

    @GetMapping("/event/{id}")
    public String getEventById(@PathVariable String id, Model model) {
        EventOut event = _EventService.getEventById(Integer.parseInt(id));
        model.addAttribute("event", event);
        model.addAttribute("location", _LocationService.getLocationById(event.getLocationId()));
        model.addAttribute("category", _CategoryService.getCategoryById(event.getCategoryId()));
        return "event";
    }

    @PostMapping("/addevent")
    public String addNewEvent(@ModelAttribute("event") EventIn event, RedirectAttributes message) {
        _EventService.addNewEvent(event);
        message.addFlashAttribute("message", "Event successfully added.");
        return "redirect:adminpanel";
    }
    
}
