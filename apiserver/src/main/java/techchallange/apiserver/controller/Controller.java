package techchallange.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techchallange.apiserver.model.AirpotModel;
import techchallange.apiserver.service.ServiceHandler;

import java.util.List;

@CrossOrigin
@RestController
public class Controller {

    @Autowired
    private ServiceHandler handler;

    @GetMapping(value = "/getAirports")
    public List<AirpotModel> getAirports() {
        return handler.getAirport();
    }

    @GetMapping(value = "/sid2waypoints/{icao}")
    public List<AirpotModel> geSID2Waypoints(@PathVariable String icao) {
        return handler.getSID2Waypoints(icao);
    }

    @GetMapping(value = "/stars2waypoints/{icao}")
    public List<AirpotModel> geStar2Waypoints(@PathVariable String icao) {
        return handler.getStars2Waypoints(icao);
    }
}
