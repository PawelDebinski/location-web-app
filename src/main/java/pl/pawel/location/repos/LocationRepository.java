package pl.pawel.location.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
