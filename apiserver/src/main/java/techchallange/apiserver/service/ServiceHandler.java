package techchallange.apiserver.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import techchallange.apiserver.model.AirportWayPointModel;
import techchallange.apiserver.model.AirpotModel;
import techchallange.apiserver.model.SIDWayPointsModel;
import techchallange.apiserver.model.StarWayPointsModel;

import java.util.*;
import java.util.Map.Entry;

@Service
public class ServiceHandler {

    public String doSomething() {
        return "i did something!";
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

    public List<SIDWayPointsModel> getSID2Waypoints(String icao) {
        //make a rest api call to the rest link
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "G9Tw58HE6HDzyq94HFmnd2yOymAuU32k2mEgL3oTVbhLl6E1opu5Hqxb5BASwCWv");

        //Create a new HttpEntity
        final HttpEntity<List<SIDWayPointsModel>> entity = new HttpEntity<List<SIDWayPointsModel>>(headers);

        // String uri = http://my-rest-url.org/rest/account/{account};


        ResponseEntity<List<SIDWayPointsModel>> response
                = restTemplate.exchange("https://open-atms.airlab.aero/api/v1/airac/sids/airport/{icao}", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<SIDWayPointsModel>>() {
                }, icao);

        return response.getBody();
    }

    public List<StarWayPointsModel> getStars2Waypoints(String icao) {
        //make a rest api call to the rest link
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("api-key", "G9Tw58HE6HDzyq94HFmnd2yOymAuU32k2mEgL3oTVbhLl6E1opu5Hqxb5BASwCWv");

        //Create a new HttpEntity
        final HttpEntity<List<StarWayPointsModel>> entity = new HttpEntity<List<StarWayPointsModel>>(headers);

        ResponseEntity<List<StarWayPointsModel>> response
                = restTemplate.exchange("https://open-atms.airlab.aero/api/v1/airac/stars/airport/{icao}", HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<StarWayPointsModel>>() {
                }, icao);

        getTop2Waypoints(response.getBody());


        return response.getBody();
    }

    private HashMap<String, Integer> getTop2Waypoints(List<StarWayPointsModel> starModel) {
        //int cnt = 0;
        String result = "";
        HashMap<String, Integer> wayPointLists = new HashMap<>();

        for (StarWayPointsModel star : starModel) {
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

        System.out.println(wayPointLists);

        List<Entry<String, Integer>> sortedList = new ArrayList<>(wayPointLists.entrySet());
        sortedList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        // test out using system out println
        System.out.println("sorted !!");
        sortedList.forEach(item -> {
            System.out.println(item.getKey() + " value: " + item.getValue());
        });

        //here
        // List<String> listofStrings = new ArrayList<>();
        HashMap<String, Integer> top2waypoints = new HashMap<>();
        int cnt = sortedList.get(0).getValue();
        for (int i = 0; i < sortedList.size(); i++) {
            if (cnt == sortedList.get(i).getValue()) {
                top2waypoints.put(sortedList.get(i).getKey(), sortedList.get(i).getValue());
            } else if (cnt > (sortedList.get(i).getValue())) {
                top2waypoints.put(sortedList.get(i).getKey(), sortedList.get(i).getValue());
                break;
            }
        }

        // melvin test
        top2waypoints.forEach((key, value) -> System.out.println(key + " " + value));


        return top2waypoints;
    }
}
