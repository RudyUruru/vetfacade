package com.project.vetfacade.service;

import com.project.vetfacade.dto.ManipulationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class ManipulationService {
    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String api = "api/v1/";

    @Autowired
    public ManipulationService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public List<ManipulationDTO> getManipulations(String name) {
            StringBuilder uri = new StringBuilder(api);
            uri.append("get_surgeons");
            if (name != null)
                uri.append("?name=").append(name);
            List<ManipulationDTO> list = localApiClient
                    .get()
                    .uri(uri.toString())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<ManipulationDTO>>() {}).block(REQUEST_TIMEOUT);

            return list.stream().toList();
    }
}
