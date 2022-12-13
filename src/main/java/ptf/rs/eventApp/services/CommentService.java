package ptf.rs.eventApp.services;

import ptf.rs.eventApp.models.entities.Comment;
import ptf.rs.eventApp.models.in.CommentIn;
import ptf.rs.eventApp.models.out.CommentOut;

import java.util.List;

public interface CommentService {
    public List<CommentOut> getCommentsForEvent(int eventId);
    public void setCommentForEvent(int eventId, CommentIn comment);
}
