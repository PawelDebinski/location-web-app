package pl.pawel.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pawel.location.entities.Location;
import pl.pawel.location.repos.LocationRepository;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") int id) {
        return locationRepository.findById(id).get();
    }

}
