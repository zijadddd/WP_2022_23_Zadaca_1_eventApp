package ptf.rs.eventApp.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.Category;
import ptf.rs.eventApp.models.entities.Event;
import ptf.rs.eventApp.models.entities.Location;
import ptf.rs.eventApp.models.in.EventIn;
import ptf.rs.eventApp.models.out.EventOut;
import ptf.rs.eventApp.repositories.CategoryRepository;
import ptf.rs.eventApp.repositories.EventRepository;
import ptf.rs.eventApp.repositories.LocationRepository;
import ptf.rs.eventApp.services.EventService;

@Service
public class EventServiceImplementation implements EventService {

    @Autowired 
    private EventRepository _EventRepository; 

    @Autowired
    private CategoryRepository _CategoryRepository;

    @Autowired
    private LocationRepository _LocationRepository;

    @Override
    public List<EventOut> getAllEvents() {
        return _EventRepository.findAll().stream().filter(e -> e.getDate().compareTo(new Date()) > 0).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public List<EventOut> getAllEventsByName(String name) {
        return _EventRepository.findAll().stream().filter(e -> e.getName().equals(name)).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public List<EventOut> getAllEventsByCategory(int id) {
        return _EventRepository.findAll().stream().filter(e -> e.getCategory().getId() == id && e.getDate().compareTo(new Date()) > 0).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public List<EventOut> getAllEventsByLocation(int id) {
        return _EventRepository.findAll().stream().filter(e -> e.getLocation().getId() == id && e.getDate().compareTo(new Date()) > 0).map(EventOut::new).collect(Collectors.toList());
    }

    @Override
    public EventOut getEventById(int id) {
        try {
            if(_EventRepository.findById(id) == null) throw new Exception("Event did not found.");
            return new EventOut(_EventRepository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Event getEventByIdForComment(int id) {
        try {
            if(_EventRepository.findById(id) == null) throw new Exception("Event did not found.");
            return _EventRepository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public EventOut addNewEvent(EventIn event) {
        Event temp = new Event(event);
        List<Category> categories = _CategoryRepository.findById(event.getCategoryId()).stream().collect(Collectors.toList());
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setCategory(categories.get(0));
        List<Location> locations = _LocationRepository.findById(event.getLocationId()).stream().collect(Collectors.toList());
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setLocation(locations.get(0));
        temp.setImgUrl(locations.get(0).getImgUrl());
        _EventRepository.save(temp);
        return new EventOut(temp);
    }

    @Override
    public EventOut editEvent(EventIn event) {
        Event temp = new Event(event);
        List<Category> categories = _CategoryRepository.findById(event.getCategoryId()).stream().collect(Collectors.toList());
        if (categories.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setCategory(categories.get(0));
        List<Location> locations = _LocationRepository.findById(event.getLocationId()).stream().collect(Collectors.toList());
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Invalid data");
        }
        temp.setLocation(locations.get(0));
        temp.setImgUrl(locations.get(0).getImgUrl());
        _EventRepository.save(temp);
        return new EventOut(temp);
    }
}
