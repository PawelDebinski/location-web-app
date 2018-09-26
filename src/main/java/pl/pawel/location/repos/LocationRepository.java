package pl.pawel.location.repos;


import org.springframework.data.repository.CrudRepository;
import pl.pawel.location.entities.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
