package ptf.rs.eventApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ptf.rs.eventApp.models.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findById(int id);
}
