package com.project.vetfacade.service;


import com.project.vetfacade.bisentity.BreedEntity;
import com.project.vetfacade.bisentity.KindEntity;
import com.project.vetfacade.pojo.BreedDataDTO;
import com.project.vetfacade.pojo.TreesDataDTO;
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


    public List<BreedEntity> getBreeds(Long id) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("all_breeds?id=").append(id);
        List<BreedDataDTO> breeds = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<BreedDataDTO>>() {}).block(REQUEST_TIMEOUT);
        return breeds.stream().map(BreedEntity::toEntity).toList();
    }

    public List<KindEntity> getKinds(Long id) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("all_kinds?id=").append(id);
        List<TreesDataDTO> kinds = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TreesDataDTO>>() {}).block(REQUEST_TIMEOUT);
        return kinds.stream().map(KindEntity::toEntity).toList();
    }
}
