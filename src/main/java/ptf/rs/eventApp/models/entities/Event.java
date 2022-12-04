package ptf.rs.eventApp.models.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import ptf.rs.eventApp.models.in.EventIn;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Size(max = 255)
    private String name;

    private Date date;

    @Size(max = 1000)
    private String description;

    @Size(max = 1000)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;

    public Event() {
    }

    public Event(EventIn eventIn) {
        this.Id = eventIn.getId();
        this.name = eventIn.getName();
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(eventIn.getDate());  
        } catch (Exception e) {}
        this.description = eventIn.getDescription();
        this.imgUrl = eventIn.getImgUrl();
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
