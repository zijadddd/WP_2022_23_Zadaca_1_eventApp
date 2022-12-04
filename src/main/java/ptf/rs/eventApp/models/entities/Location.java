package ptf.rs.eventApp.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import ptf.rs.eventApp.models.in.LocationIn;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    private String name;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Event> events;

    public Location() {
    }

    public Location(int id) {
        this.id = id;
        this.name = "null";
    } 

    public Location(LocationIn eventLocationIn) {
        this.id = eventLocationIn.getId();
        this.name = eventLocationIn.getName();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
}
