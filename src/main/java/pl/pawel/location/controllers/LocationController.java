package pl.pawel.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawel.location.entities.Location;
import pl.pawel.location.service.LocationService;

@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location")Location location) {
        service.saveLocation(location);
        return "createLocation";
    }
}
