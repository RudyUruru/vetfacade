package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.BreedEntity;
import com.project.vetfacade.bisentity.KindEntity;
import com.project.vetfacade.service.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class FilterController {

    @Autowired
    FiltersService filtersService;

    @GetMapping("/all_breeds")
    public ResponseEntity<List<BreedEntity>> getBreedFilter() {
        return ResponseEntity.ok(filtersService.getBreeds(UserInfo.ID));
    }

    @GetMapping("/all_kinds")
    public ResponseEntity<List<KindEntity>> getKindFilter() {
        return ResponseEntity.ok(filtersService.getKinds(UserInfo.ID));
    }
}