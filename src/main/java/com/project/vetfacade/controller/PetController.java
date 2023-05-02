package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.PetLightEntity;
import com.project.vetfacade.service.PetService;
import com.project.vetfacade.user.User;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class PetController {
    @Autowired
    PetService petService;

    //посмотреть
    @GetMapping("/pets")
    public ResponseEntity<List<PetLightEntity>> getPetsFiltered(
            @RequestParam @Nullable Long kind_id,
            @RequestParam @Nullable Long breed_id,
            @RequestParam @Nullable Integer max_count) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(petService.getPets(user.getEmail(), kind_id, breed_id, max_count));
    }
}
