package com.project.vetfacade.controller;

import com.project.vetfacade.dto.ManipulationDTO;
import com.project.vetfacade.service.ManipulationService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ManipulationController {
    @Autowired
    private ManipulationService manipulationService;
    @GetMapping("/get_surgeons")
    public ResponseEntity<List<ManipulationDTO>> getSurgeons(@Nullable @RequestParam String name) {
        return ResponseEntity.ok(manipulationService.getManipulations(name));
    }
}
