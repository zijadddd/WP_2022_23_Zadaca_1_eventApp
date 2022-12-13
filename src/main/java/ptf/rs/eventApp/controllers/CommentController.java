package ptf.rs.eventApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ptf.rs.eventApp.models.in.CommentIn;
import ptf.rs.eventApp.services.CommentService;

@Controller
public class CommentController {

    @Autowired
    private CommentService _CommentService;

    @PostMapping("/addcomment/{eventId}")
    public String addNewEvent(@PathVariable String eventId, @ModelAttribute("comment") CommentIn comment) {
        _CommentService.setCommentForEvent(Integer.parseInt(eventId), comment);
        return "redirect:/event/" + eventId;
    }

}
