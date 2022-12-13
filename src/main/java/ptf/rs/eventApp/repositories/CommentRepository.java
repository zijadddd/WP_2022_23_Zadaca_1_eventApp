package ptf.rs.eventApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptf.rs.eventApp.models.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
