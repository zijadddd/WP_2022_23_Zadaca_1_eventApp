package ptf.rs.eventApp.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.Location;
import ptf.rs.eventApp.models.in.LocationIn;
import ptf.rs.eventApp.models.out.EventOut;
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
        return locations.stream().map(LocationOut::new).collect(Collectors.toList());
    }

    @Override
    public LocationOut getLocationById(int id) {
        try {
            if(_LocationRepository.findById(id) == null) throw new Exception("Location did not found.");
            return new LocationOut(_LocationRepository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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
