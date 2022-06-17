package techchallange.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportWayPointModel {

    public AirportWayPointModel()
    {

    }

    public AirportWayPointModel(String uid, String name, double lat, double lng) {
        this.uid  = uid;
        this.name = name;
        this.lat  = lat;
        this.lng  = lng;
    }

    private String uid;
    private String name;
    private double lat;
    private double lng;


    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

}
