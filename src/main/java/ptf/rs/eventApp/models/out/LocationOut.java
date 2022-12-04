package ptf.rs.eventApp.models.out;

import ptf.rs.eventApp.models.entities.Location;

public class LocationOut {
    private Integer id;
    private String name;
    
    public LocationOut() {
    }

    public LocationOut(Location location) {
        this.id = location.getId();
        this.name = location.getName();
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

    
    
}
