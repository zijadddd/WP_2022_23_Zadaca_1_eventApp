package ptf.rs.eventApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.out.CategoryOut;
import ptf.rs.eventApp.services.CategoryService;

@Controller
public class CategoryController {
    
    @Autowired 
    private CategoryService _CategoryService;

    @GetMapping("/getcategories")
    public List<CategoryOut> getAllCategories() {
        return _CategoryService.getAllCategories();
    }


    @PostMapping("/addcategory")
    public String addNewCategory(@ModelAttribute("category") CategoryIn category, RedirectAttributes message) {
        _CategoryService.addNewCategory(category);
        message.addFlashAttribute("message", "Category successfully added");
        return "redirect:adminpanel";
    }
}
