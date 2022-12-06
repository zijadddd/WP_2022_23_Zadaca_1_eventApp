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

    @Size(max = 1000)
    private String description;

    @Size(max = 1000)
    private String imgUrl;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Event> events;

    public Location() {
    }

    public Location(LocationIn eventLocationIn) {
        this.id = eventLocationIn.getId();
        this.name = eventLocationIn.getName();
        this.description = eventLocationIn.getDescription();
        this.imgUrl = eventLocationIn.getImgUrl();
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
    
}
