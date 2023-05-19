package com.project.vetfacade.controller;


import com.project.vetfacade.bisentity.PetEntity;
import com.project.vetfacade.bisentity.PetLightEntity;
import com.project.vetfacade.service.PetService;
import com.project.vetfacade.user.User;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class PetController {
    @Autowired
    PetService petService;


    @GetMapping("/pets")
    public ResponseEntity<List<PetLightEntity>> getPetsFiltered(
            @RequestParam @Nullable Long kind_id,
            @RequestParam @Nullable Long breed_id,
            @RequestParam @Nullable String name,
            @RequestParam @Nullable Integer max_count) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(petService.getPets(user.getEmail(), kind_id, breed_id, name, max_count));
    }

    @GetMapping("/get_pet")
    public ResponseEntity<PetEntity> getPet(@RequestParam("pet_id") Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }


}
