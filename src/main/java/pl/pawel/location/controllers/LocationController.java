package pl.pawel.location.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawel.location.entities.Location;
import pl.pawel.location.repos.LocationRepository;
import pl.pawel.location.service.LocationService;
import pl.pawel.location.util.EmailUtil;
import pl.pawel.location.util.ReportUtil;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext sc;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @PostMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("iammarrypoppinsyo@gmail.com", "iammarrypoppinsyo@gmail.com",
                            "Location Saved", "Location Saved Successfully and about to return a response");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);

        return "displayLocations";
    }

    @RequestMapping("deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        service.deleteLocation(location);
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = service.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
        service.updateLocation(location);
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport() {
        String path = sc.getRealPath("/");

        List<Object[]> data = locationRepository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }
}
