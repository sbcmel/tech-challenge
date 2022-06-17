package techchallange.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StarWayPointsModel {

//    private String name;
//    private AirportWayPointModel airportList;
//    private AirportWayPointModel waypointList;

    public StarWayPointsModel() {

    }

    public StarWayPointsModel(String name,
                             AirportWayPointModel airport,
                             List<AirportWayPointModel> waypointList) {
        this.name = name;
        this.airport = airport;
        this.waypointList = waypointList;
    }

    private String name;
    @JsonProperty("airport")
    private AirportWayPointModel airport;

    @JsonProperty("waypoints")
    private List<AirportWayPointModel> waypointList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AirportWayPointModel getAirport() {
        return airport;
    }

    public void setAirport(AirportWayPointModel airport) {
        this.airport = airport;
    }

    public List<AirportWayPointModel> getWaypointList() {
        return waypointList;
    }

    public void setWaypointList(List<AirportWayPointModel> waypointList) {
        this.waypointList = waypointList;
    }
}
