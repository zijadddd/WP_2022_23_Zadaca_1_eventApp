package ptf.rs.eventApp.models.out;

import java.util.Date;
import java.util.Optional;

import ptf.rs.eventApp.models.entities.Event;

public class EventOut {
    private Integer Id;
    private String name;
    private Date date;
    private String description;
    private String imgUrl;
    private Integer categoryId;
    private Integer locationId;
    public EventOut() {
    }
    public EventOut(Event event) {
        this.Id = event.getId();
        this.name = event.getName();
        this.date = event.getDate();
        this.description = event.getDescription();
        this.imgUrl = event.getImgUrl();
        this.categoryId = event.getCategory().getId();
        this.locationId = event.getLocation().getId();
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
    public Integer getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getLocationId() {
        return this.locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    
}
