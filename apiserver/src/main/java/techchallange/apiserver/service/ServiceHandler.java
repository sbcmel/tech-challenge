package techchallange.apiserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import techchallange.apiserver.model.AirportWayPointModel;
import techchallange.apiserver.model.AirpotModel;
import techchallange.apiserver.model.WayPointsModel;
import techchallange.apiserver.model.StarWayPointsModel;

import java.util.*;
import java.util.Map.Entry;

@Service
public class ServiceHandler {
    private final String apiKey;

    public ServiceHandler(@Value("#{environment.API_KEY}") String apiKey) {
        this.apiKey = apiKey;
        System.out.println(this.apiKey);
    }

    public List<AirpotModel> getAirport() {
        //make a rest api call to the airlab link
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "G9Tw58HE6HDzyq94HFmnd2yOymAuU32k2mEgL3oTVbhLl6E1opu5Hqxb5BASwCWv");
        //Create a new HttpEntity
        final HttpEntity<List<AirpotModel>> entity = new HttpEntity<List<AirpotModel>>(headers);
        ResponseEntity<List<AirpotModel>> response
                = restTemplate.exchange("https://open-atms.airlab.aero/api/v1/airac/airports", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<AirpotModel>>() {
                });
        return response.getBody();
    }

    public List<AirpotModel> getSID2Waypoints(String icao) {
        //make a rest api call to the rest link
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "G9Tw58HE6HDzyq94HFmnd2yOymAuU32k2mEgL3oTVbhLl6E1opu5Hqxb5BASwCWv");

        //Create a new HttpEntity
        final HttpEntity<List<WayPointsModel>> entity = new HttpEntity<List<WayPointsModel>>(headers);

        // String uri = http://my-rest-url.org/rest/account/{account};


        ResponseEntity<List<WayPointsModel>> response
                = restTemplate.exchange("https://open-atms.airlab.aero/api/v1/airac/sids/airport/{icao}", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<WayPointsModel>>() {
                }, icao);

        List<AirpotModel> top2 = getTop2Waypoints(response.getBody());

        return top2; //response.getBody();
    }

    public List<AirpotModel> getStars2Waypoints(String icao) {
        //make a rest api call to the rest link
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "G9Tw58HE6HDzyq94HFmnd2yOymAuU32k2mEgL3oTVbhLl6E1opu5Hqxb5BASwCWv");

        //Create a new HttpEntity
        final HttpEntity<List<StarWayPointsModel>> entity = new HttpEntity<List<StarWayPointsModel>>(headers);

        ResponseEntity<List<WayPointsModel>> response
                = restTemplate.exchange("https://open-atms.airlab.aero/api/v1/airac/stars/airport/{icao}", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<WayPointsModel>>() {
                }, icao);

        List<AirpotModel> top2 = getTop2Waypoints(response.getBody());

        return top2;
    }

    private List<AirpotModel> getTop2Waypoints(List<WayPointsModel> starModel) {
        List<AirpotModel> top2waypoints = new ArrayList<>();
        if (starModel.isEmpty()) {
            return top2waypoints;
        }

        String result = "";
        HashMap<String, Integer> wayPointLists = new HashMap<>();

        for (WayPointsModel star : starModel) {
            List<AirportWayPointModel> wpList = star.getWaypointList();
            for (AirportWayPointModel wp : wpList) {
                String key = wp.getName();
                if (wayPointLists.containsKey(key)) {
                    wayPointLists.put(key, wayPointLists.get(key) + 1);
                } else {
                    wayPointLists.put(key, 1);
                }
            }
        }

        List<Entry<String, Integer>> sortedList = new ArrayList<>(wayPointLists.entrySet());
        sortedList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        // test out using system out println
        sortedList.forEach(item -> {
            System.out.println(item.getKey() + " value: " + item.getValue());
        });

        int cnt = sortedList.get(0).getValue();
        for (int i = 0; i < sortedList.size(); i++) {
            AirpotModel model = new AirpotModel();
            if (cnt == sortedList.get(i).getValue()) {
                model.setName(sortedList.get(i).getKey());
                model.setWpFrequency(sortedList.get(i).getValue());
                top2waypoints.add(model);
            } else if (cnt > (sortedList.get(i).getValue())) {
                model.setName(sortedList.get(i).getKey());
                model.setWpFrequency(sortedList.get(i).getValue());
                top2waypoints.add(model);
                break;
            }
        }
        return top2waypoints;
    }
}
