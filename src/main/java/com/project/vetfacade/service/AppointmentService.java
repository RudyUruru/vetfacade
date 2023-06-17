package com.project.vetfacade.service;


import com.project.vetfacade.bisentity.AppointmentEntity;
import com.project.vetfacade.dto.AppointmentDTO;
import com.project.vetfacade.dto.AppointmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.LocalDateTime;
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

    public List<AppointmentEntity> getAppointments(String email, Long petId, Integer max_count) {
        StringBuilder uri = new StringBuilder(api);
        uri.append("appointments?email=").append(email);
        if (max_count != null)
            uri.append("&max_count=").append(max_count);
        if (petId != null)
            uri.append("&petId=").append(petId);
        List<AppointmentDTO> list = localApiClient
                .get()
                .uri(uri.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AppointmentDTO>>() {}).block(REQUEST_TIMEOUT);

        return list.stream().map(AppointmentEntity::toEntity).toList();
    }

    public ResponseEntity makeAppointment(String email, Long petId, LocalDateTime date, Long surgeonId, AppointmentType type) {
        String uri = "api/v1/make_appointment"
                + "?email=" + email
                + "&pet_id=" + petId
                + "&date=" + date
                + "&surgeon_id=" + surgeonId
                + "&type=" + type;

        return localApiClient.post().uri(uri).retrieve().bodyToMono(ResponseEntity.class).block(REQUEST_TIMEOUT);
    }
}
