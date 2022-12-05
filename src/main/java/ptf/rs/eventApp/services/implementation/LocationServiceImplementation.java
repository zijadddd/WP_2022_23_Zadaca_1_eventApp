package ptf.rs.eventApp.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.Location;
import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.out.LocationOut;
import ptf.rs.eventApp.repositories.LocationRepository;
import ptf.rs.eventApp.services.LocationService;

@Service
public class LocationServiceImplementation implements LocationService {
    
    @Autowired
    private LocationRepository _LocationRepository;

    @Override
    public List<LocationOut> getAllLocations() {
        List<Location> locations = _LocationRepository.findAll();
        List<LocationOut> processedLocations = new ArrayList<LocationOut>();
        for(Location location : locations) processedLocations.add(new LocationOut(location));
        return processedLocations;
    }

    @Override
    public LocationOut addNewLocation(LocationIn locationIn) {
        List<LocationOut> addedLocations = this.getAllLocations();
        Location temp;
        try {
            temp = new Location(locationIn);
            for(LocationOut location : addedLocations) if(location.getName().equals(temp.getName())) throw new Exception("Lokacija vec postoji.");
            _LocationRepository.save(temp);
            return new LocationOut(temp);
        } catch(Exception e) {}
        return null;
    }
}
