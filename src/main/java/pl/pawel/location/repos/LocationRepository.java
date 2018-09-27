package pl.pawel.location.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pawel.location.entities.Location;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query("select type, count(type) from location group by type")
    public List<Object[]> findTypeAndTypeCount();

}
