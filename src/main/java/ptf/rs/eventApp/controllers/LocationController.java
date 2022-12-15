package ptf.rs.eventApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.out.LocationOut;
import ptf.rs.eventApp.services.LocationService;

@Controller
public class LocationController {
    
    @Autowired
    private LocationService _LocationService;

    @GetMapping("/getlocations")
    public List<LocationOut> getAllLocations() {
        return _LocationService.getAllLocations();
    } 


    @PostMapping("/addlocation")
    public String addNewLocation(@ModelAttribute("location") LocationIn location, RedirectAttributes message) {
        _LocationService.addNewLocation(location);
        message.addFlashAttribute("message", "Location successfully added");
        return "redirect:adminpanel";
    }

    @PostMapping("/editlocation")
    public String editLocation(@ModelAttribute("locationforedit") LocationIn location, RedirectAttributes message) {
        _LocationService.editLocation(location);
        message.addFlashAttribute("message", "Location successfully edited");
        return "redirect:adminpanel";
    }
}
