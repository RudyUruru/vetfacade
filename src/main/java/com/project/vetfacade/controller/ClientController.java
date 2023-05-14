package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.*;
import com.project.vetfacade.service.AppointmentService;
import com.project.vetfacade.service.ClientService;
import com.project.vetfacade.user.User;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/v2")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentEntity>> getAppointments(@Nullable @RequestParam Integer max_count) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(appointmentService.getAppointments(user.getEmail(), max_count));
    }

    @GetMapping("/analysis")
    public ResponseEntity<AnalysisEntity> getAnalysisMain() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(clientService.getAnalysis(user.getEmail()));
    }

    @GetMapping("/client_info")
    public ResponseEntity<ClientEntity> getClientFullName(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(clientService.getClientInfo(user.getEmail()));
    }

    @GetMapping("/clinic")
    public ResponseEntity<ConfigurationEntity> getClinicInformation() {
        return ResponseEntity.ok(clientService.getClinicInformation());
    }

    //Можно добавить в фильтры еще одну дату и искать между ними
    @GetMapping("/visits")
    public ResponseEntity<List<VisitEntity>> getVisits(
            @RequestParam @Nullable Long kind_id,
            @RequestParam @Nullable Long breed_id,
            @RequestParam @Nullable LocalDateTime date1, @RequestParam @Nullable LocalDateTime date2,
            @RequestParam @Nullable Integer max_count) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(clientService.getVisits(user.getEmail(), kind_id, breed_id, date1, date2, max_count));
    }
}

