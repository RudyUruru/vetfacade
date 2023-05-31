package com.project.vetfacade.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.vetfacade.bisentity.WorkTimeEntity;
import com.project.vetfacade.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WorkTimeController {
    @Autowired
    private WorkTimeService workTimeService;
    @GetMapping("/get_free_time")
    public ResponseEntity<WorkTimeEntity> getFreeTime(@RequestParam("doctor_id") Long doctorId, LocalDateTime date) {
        return ResponseEntity.ok(workTimeService.getFreeTime(doctorId, date));
    }

}
