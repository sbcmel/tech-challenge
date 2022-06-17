package techchallange.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import techchallange.apiserver.model.AirpotModel;
import techchallange.apiserver.model.SIDWayPointsModel;
import techchallange.apiserver.model.StarWayPointsModel;
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
    public List<SIDWayPointsModel> geSID2Waypoints(@PathVariable String icao ) {
        return handler.getSID2Waypoints(icao);
    }

    @GetMapping(value = "/stars2waypoints/{icao}")
    public List<StarWayPointsModel> geStar2Waypoints(@PathVariable String icao ) {
        return handler.getStars2Waypoints(icao);
    }
//    @GetMapping(value = "/star2waypoints")
//   public List<AirpotModel> gestar2Waypoints() {
//          return handler.geSID2Waypoints();
 //   }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome()
    {
        return "welcome!!";
    }
}
