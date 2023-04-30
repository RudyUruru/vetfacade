package com.project.vetfacade.service;


import com.project.vetfacade.bisentity.AppointmentEntity;
import com.project.vetfacade.pojo.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.List;

@Service
public class AppointmentService {

    private final WebClient localApiClient;
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
    private static final String api = "api/v2/";

    @Autowired
    public AppointmentService(WebClient localApiClient) {
        this.localApiClient = localApiClient;
    }

    public List<AppointmentEntity> getAppointments(String email, Integer max_count) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("appointments?email=").append(email);
        if (max_count != null)
            uri.append("&max_count=").append(max_count);

        List<AppointmentDTO> list = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AppointmentDTO>>() {}).block(REQUEST_TIMEOUT);

        return list.stream().map(AppointmentEntity::toEntity).toList();
    }
}
