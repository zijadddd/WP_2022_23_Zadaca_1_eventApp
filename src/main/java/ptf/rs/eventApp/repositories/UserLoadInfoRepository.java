package ptf.rs.eventApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ptf.rs.eventApp.models.entities.User;

@Repository
public interface UserLoadInfoRepository extends JpaRepository < User, Integer > {
    User findByEmail(String email);
}
