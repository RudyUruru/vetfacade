package com.project.vetfacade.service;

import com.project.vetfacade.bisentity.VisitHistoryEntity;
import com.project.vetfacade.pojo.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class VisitService {
    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String api = "api/v4/";

    @Autowired
    public VisitService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public VisitHistoryEntity getVisit(Long visit_id) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("visit?visit_id=").append(visit_id);
        VisitDTO visit = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(VisitDTO.class).block(REQUEST_TIMEOUT);
        return VisitHistoryEntity.toEntity(visit);
    }
}
