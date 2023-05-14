package com.project.vetfacade.service;

import com.project.vetfacade.bisentity.AnalysisEntity;
import com.project.vetfacade.bisentity.ClientEntity;
import com.project.vetfacade.bisentity.ConfigurationEntity;
import com.project.vetfacade.bisentity.VisitEntity;
import com.project.vetfacade.dto.ClientLightDTO;
import com.project.vetfacade.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientService {

    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String api = "api/v2/";

    @Autowired
    public ClientService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }


    public AnalysisEntity getAnalysis(String email) {
        return new AnalysisEntity();
    }

    public ConfigurationEntity getClinicInformation() {
        return new ConfigurationEntity();
    }

    public ClientEntity getClientInfo(String email) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("client_info?email=").append(email);
        return ClientEntity.toEntity(localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(ClientLightDTO.class).block(REQUEST_TIMEOUT));
    }

    public List<VisitEntity> getVisits(String email, Long kind_id, Long breed_id, LocalDateTime date1, LocalDateTime date2, Integer max_count) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("visits?email=").append(email);
        if (kind_id!=null)
            uri.append("&kind_id=").append(kind_id);
        if (breed_id!=null)
            uri.append("&bred_id=").append(breed_id);
        if (date1!=null)
            uri.append("&date1=").append(date1);
        if (date2!=null)
            uri.append("&date2=").append(date2);
        if (max_count!=null)
            uri.append("&max_count=").append(max_count);
        List<VisitDTO> list = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<VisitDTO>>() {}).block(REQUEST_TIMEOUT);
        return list.stream().map(VisitEntity::toEntity).toList();
    }
}
