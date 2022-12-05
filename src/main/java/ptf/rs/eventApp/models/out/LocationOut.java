package ptf.rs.eventApp.models.out;

import ptf.rs.eventApp.models.entities.Location;

public class LocationOut {
    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    
    public LocationOut() {
    }

    public LocationOut(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.description = location.getDescription();
        this.imgUrl = location.getImgUrl();
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
