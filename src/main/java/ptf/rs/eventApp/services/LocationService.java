package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.entities.Location;
import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.out.LocationOut;

public interface LocationService {
    public List<LocationOut> getAllLocations();
    public LocationOut getLocationById(int id);
    public Location getLocation(int id);
    public LocationOut addNewLocation(LocationIn locationIn);
    public void editLocation(LocationIn locationIn);
}
