package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.entities.Event;
import ptf.rs.eventApp.models.in.EventIn;
import ptf.rs.eventApp.models.out.EventOut;

public interface EventService {
    public List<EventOut> getAllEvents();
    public List<EventOut> getAllEventsByCategory(int id);
    public List<EventOut> getAllEventsByLocation(int id);
    public EventOut getEventById(int id);
    public Event getEventByIdForComment(int id);
    public EventOut addNewEvent(EventIn event);
}
