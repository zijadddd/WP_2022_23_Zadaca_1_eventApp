package ptf.rs.eventApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ptf.rs.eventApp.models.entities.Location;
import ptf.rs.eventApp.models.out.LocationOut;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findById(int id);
}
