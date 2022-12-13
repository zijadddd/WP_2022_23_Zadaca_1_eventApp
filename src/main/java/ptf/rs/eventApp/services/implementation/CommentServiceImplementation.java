package ptf.rs.eventApp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ptf.rs.eventApp.models.entities.Comment;
import ptf.rs.eventApp.models.entities.Event;
import ptf.rs.eventApp.models.entities.User;
import ptf.rs.eventApp.models.in.CommentIn;
import ptf.rs.eventApp.models.out.CommentOut;
import ptf.rs.eventApp.repositories.CommentRepository;
import ptf.rs.eventApp.services.CommentService;
import ptf.rs.eventApp.services.EventService;
import ptf.rs.eventApp.services.UserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository _CommentRepository;

    @Autowired
    private EventService _EventService;

    @Autowired
    private UserService _UserService;

    @Override
    public List<CommentOut> getCommentsForEvent(int eventId) {
        return (List<CommentOut>) _CommentRepository
                                    .findAll()
                                    .stream()
                                    .filter(c -> c.getEvent().getId() == eventId)
                                    .map(CommentOut::new).collect(Collectors.toList());
    }

    @Override
    public void setCommentForEvent(int eventId, CommentIn comment) {
        if(comment == null) throw new IllegalArgumentException("Comment is null");
        Event event = _EventService.getEventByIdForComment(eventId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = _UserService.getUserByEmail(userEmail);
        Comment temp = new Comment(comment);
        temp.setEvent(event);
        temp.setUser(user);
        temp.setDate(new Date());
        _CommentRepository.save(temp);
    }
}
