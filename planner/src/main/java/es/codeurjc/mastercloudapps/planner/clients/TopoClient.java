package es.codeurjc.mastercloudapps.planner.clients;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;

@Service
public class TopoClient {

    @Value("${toposervice.host}")
    private String TOPO_HOST;

    @Value("${toposervice.port}")
    private String TOPO_PORT;

    @Async
    public CompletableFuture<String> getLandscape(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://"+TOPO_HOST+":"+TOPO_PORT+"/api/topographicdetails/" + city;
        LandscapeResponse response = restTemplate.getForObject(url, LandscapeResponse.class);
        return CompletableFuture.completedFuture(response.getLandscape());
    }
}
