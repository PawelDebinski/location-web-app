package pl.pawel.location.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawel.location.entities.Location;
import pl.pawel.location.repos.LocationRepository;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository repository;

    @Override
    public Location saveLocation(Location location) {
        LOGGER.info("=== Inside saveLocation()");
        return repository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        LOGGER.info("=== Inside updateLocation()");
        return repository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        LOGGER.info("=== Inside deleteLocation()");
        repository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        LOGGER.info("=== Inside getLocationById()");
        return repository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        LOGGER.info("=== Inside getAllLocations()");
        return repository.findAll();
    }

}
