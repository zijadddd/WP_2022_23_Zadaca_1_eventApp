package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.models.in.EventIn;
import ptf.rs.eventApp.models.out.EventOut;
import ptf.rs.eventApp.services.*;

@Controller
public class EventController {
    
    @Autowired
    private EventService _EventService;

    @Autowired
    private LocationService _LocationService;

    @Autowired
    private CategoryService _CategoryService;

    @Autowired
    private CommentService _CommentService;

    @GetMapping("/")
    public String getAllEvents(@RequestParam(value = "categoryId", required = false) String categoryId, @RequestParam(value = "locationId", required = false) String locationId, Model model) {
        if(categoryId != null) model.addAttribute("events", _EventService.getAllEventsByCategory(Integer.parseInt(categoryId)));
        else if (locationId != null) model.addAttribute("events", _EventService.getAllEventsByLocation(Integer.parseInt(locationId)));
        else model.addAttribute("events", _EventService.getAllEvents());
        model.addAttribute("locations", _LocationService.getAllLocations());
        model.addAttribute("categories", _CategoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/event/{id}")
    public String getEventById(@PathVariable String id, Model model) {
        EventOut event = _EventService.getEventById(Integer.parseInt(id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        model.addAttribute("event", event);
        model.addAttribute("location", _LocationService.getLocationById(event.getLocationId()));
        model.addAttribute("category", _CategoryService.getCategoryById(event.getCategoryId()));
        model.addAttribute("comments", _CommentService.getCommentsForEvent(Integer.parseInt(id)));
        model.addAttribute("adminEmail", userName);
        return "event";
    }

    @PostMapping("/addevent")
    public String addNewEvent(@ModelAttribute("event") EventIn event, RedirectAttributes message) {
        _EventService.addNewEvent(event);
        message.addFlashAttribute("message", "Event successfully added.");
        return "redirect:adminpanel";
    }
    
}
