package techchallange.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirpotModel {

    public AirpotModel()
    {

    }

    public AirpotModel(String name, String icao) {
        this.name = name;
        this.icao = icao;
    }

    private String name;
    private String icao;

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
