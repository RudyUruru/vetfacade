package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.*;
import com.project.vetfacade.service.AppointmentService;
import com.project.vetfacade.service.ClientService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<AppointmentEntity>> getAppointments(/*@RequestParam Long id,*/ @Nullable @RequestParam Integer max_count) {
        return ResponseEntity.ok(appointmentService.getAppointments(UserInfo.ID, max_count));
    }

    @GetMapping("/analysis")
    public ResponseEntity<AnalysisEntity> getAnalysisMain(/*@RequestParam Long id*/) {
        return ResponseEntity.ok(clientService.getAnalysis(UserInfo.ID));
    }

    @GetMapping("/client_info")
    public ResponseEntity<ClientEntity> getClientFullName(/*@RequestParam Long id*/) {
        return ResponseEntity.ok(clientService.getClientInfo(UserInfo.ID));
    }

    @GetMapping("/clinic")
    public ResponseEntity<ConfigurationEntity> getClinicInformation() {
        return ResponseEntity.ok(clientService.getClinicInformation());
    }

    //Можно добавить в фильтры еще одну дату и искать между ними
    @GetMapping("/visits")
    public ResponseEntity<List<VisitEntity>> getVisits(/*@RequestParam Long id,*/
                                                    @RequestParam @Nullable Long kind_id,
                                                    @RequestParam @Nullable Long breed_id,
                                                    @RequestParam @Nullable LocalDateTime date1, @RequestParam @Nullable LocalDateTime date2,
                                                    @RequestParam @Nullable Integer max_count) {
        return ResponseEntity.ok(clientService.getVisits(UserInfo.ID, kind_id, breed_id, date1, date2, max_count));
    }
}
