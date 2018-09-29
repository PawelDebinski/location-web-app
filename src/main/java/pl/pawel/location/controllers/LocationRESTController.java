package pl.pawel.location.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pawel.location.entities.Location;
import pl.pawel.location.repos.LocationRepository;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationRESTController.class);

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations() {
        LOGGER.info("=== Inside getLocations()");
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        LOGGER.info("=== Inside createLocation() -> Location: {}", location);
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        LOGGER.info("=== Inside updateLocation() -> Location: {}", location);
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        LOGGER.info("=== Inside deleteLocation() -> id: {}", id);
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {
        LOGGER.info("=== Inside getLocation() -> id: {}", id);
        return locationRepository.findById(id).get();
    }

}
