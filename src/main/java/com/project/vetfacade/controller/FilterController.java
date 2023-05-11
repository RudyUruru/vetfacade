package com.project.vetfacade.controller;


import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.BreedEntity;
import com.project.vetfacade.bisentity.KindEntity;
import com.project.vetfacade.service.FiltersService;
import com.project.vetfacade.user.User;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v3")
public class FilterController {

    @Autowired
    FiltersService filtersService;

    @GetMapping("/all_breeds")
    public ResponseEntity<List<BreedEntity>> getBreedFilter(@AuthenticationPrincipal User user, @Nullable @RequestParam Long kind_id) {
        return ResponseEntity.ok(filtersService.getBreeds(user.getEmail(), kind_id));
    }

    @GetMapping("/all_kinds")
    public ResponseEntity<List<KindEntity>> getKindFilter(@AuthenticationPrincipal User user, @Nullable @RequestParam Long breed_id) {
        return ResponseEntity.ok(filtersService.getKinds(user.getEmail(), breed_id));
    }
}