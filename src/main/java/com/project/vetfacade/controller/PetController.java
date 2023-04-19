package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.PetLightEntity;
import com.project.vetfacade.service.PetService;
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
public class PetController {
    @Autowired
    PetService petService;

    //посмотреть
    @GetMapping("/pets")
    public ResponseEntity<List<PetLightEntity>> getPetsFiltered(/*@RequestParam Long id,*/
                                                                @RequestParam @Nullable Long kind_id,
                                                                @RequestParam @Nullable Long breed_id,
                                                                @RequestParam @Nullable Integer max_count) {
        return ResponseEntity.ok(petService.getPets(UserInfo.ID, kind_id, breed_id, max_count));
    }
}
