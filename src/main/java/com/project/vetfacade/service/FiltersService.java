package com.project.vetfacade.service;


import com.project.vetfacade.bisentity.BreedEntity;
import com.project.vetfacade.bisentity.KindEntity;
import com.project.vetfacade.dto.BreedDataDTO;
import com.project.vetfacade.dto.TreesDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class FiltersService {

    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    public static final String api = "api/v3/";
    @Autowired
    public FiltersService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }


    public List<BreedEntity> getBreeds(String email, Long kindId) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("all_breeds?email=").append(email);
        if (kindId != null)
            uri.append("&kind_id=").append(kindId);
        List<BreedDataDTO> breeds = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<BreedDataDTO>>() {}).block(REQUEST_TIMEOUT);
        return breeds.stream().map(BreedEntity::toEntity).toList();
    }

    public List<KindEntity> getKinds(String email, Long breedId) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("all_kinds?email=").append(email);
        if (breedId != null)
            uri.append("&breed_id=").append(breedId);
        List<TreesDataDTO> kinds = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TreesDataDTO>>() {}).block(REQUEST_TIMEOUT);
        return kinds.stream().map(KindEntity::toEntity).toList();
    }
}
