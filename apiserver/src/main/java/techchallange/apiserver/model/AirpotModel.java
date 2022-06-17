package techchallange.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirpotModel {

    public AirpotModel() {
    }
    public AirpotModel(String name, String icao, int wpFrequency) {
        this.name = name;
        this.icao = icao;
        this.wpFrequency =wpFrequency;
    }

    private String name;
    private String icao;
    private int wpFrequency;
    public int getWpFrequency() {
        return wpFrequency;
    }

    public void setWpFrequency(int wpFrequency) {
        this.wpFrequency = wpFrequency;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public void print()
    {
        System.out.println("name: "+name + " icao: " + icao);
    }
}
