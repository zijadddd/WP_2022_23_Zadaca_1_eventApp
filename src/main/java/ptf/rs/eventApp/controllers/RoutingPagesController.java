package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ptf.rs.eventApp.models.entities.User;
import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.in.UserIn;
import ptf.rs.eventApp.services.CategoryService;
import ptf.rs.eventApp.services.EventService;
import ptf.rs.eventApp.services.LocationService;
import ptf.rs.eventApp.services.UserService;

@Controller
public class RoutingPagesController {

    @Autowired
    private LocationService _LocationService;

    @Autowired 
    private CategoryService _CategoryService;

    @Autowired
    private UserService _UserService;

    @Autowired
    private EventService _EventService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        UserIn user = new UserIn();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/addlocation")
    public String addLocationPage(Model model) {
        LocationIn location = new LocationIn();
        model.addAttribute("location", location);
        return "addlocation";
    }

    @GetMapping("/addcategory")
    public String addCategoryPage(Model model) {
        CategoryIn category = new CategoryIn();
        model.addAttribute("category", category);
        return "addcategory";
    }

    @GetMapping("/adminpanel")
    public String adminPanelPage(Model model) {
        model.addAttribute("locations", _LocationService.getAllLocations());
        model.addAttribute("categories", _CategoryService.getAllCategories());
        return "adminPanel";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        User temp = _UserService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("user", temp);
        return "profile";
    }

    @GetMapping("/event")
    public String eventPage() {
        return "event";
    }
}
