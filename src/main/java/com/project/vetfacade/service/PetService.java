package com.project.vetfacade.service;

import com.project.vetfacade.bisentity.PetLightEntity;
import com.project.vetfacade.pojo.PetLightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;


@Service
public class PetService {

    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String api = "api/v1/";

    @Autowired
    public PetService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    @CrossOrigin(origins = "*")
    public List<PetLightEntity> getPets(String email, Long kind_id, Long breed_id, String name, Integer max_count) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("pets?email=").append(email);
        if (kind_id != null)
            uri.append("&kind_id=").append(kind_id);
        if (breed_id != null)
            uri.append("&breed_id=").append(breed_id);
        if (name != null)
            uri.append("&name=").append(name);
        if (max_count != null)
            uri.append("&max_count=").append(max_count);
        List<PetLightDTO> pets = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<PetLightDTO>>() {
                }).block(REQUEST_TIMEOUT);
        return pets.stream().map(PetLightEntity::toEntity).toList();
    }

    public List<PetLightEntity> getPetsByName(String email, String name) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("/pets_name?email=").append(email);
        uri.append("&name=").append(name);
        List<PetLightDTO> pets = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<PetLightDTO>>() {
                }).block(REQUEST_TIMEOUT);
        return pets.stream().map(PetLightEntity::toEntity).toList();
    }
}
