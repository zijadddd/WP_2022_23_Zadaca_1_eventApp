package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.out.LocationOut;

public interface LocationService {
    public List<LocationOut> getAllLocations();
    public LocationOut addNewLocation(LocationIn locationIn);
}
