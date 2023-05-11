package com.project.vetfacade.controller;

import com.project.vetfacade.UserInfo;
import com.project.vetfacade.bisentity.VisitHistoryEntity;
import com.project.vetfacade.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
public class VisitController {
    @Autowired
    VisitService visitService;

    @GetMapping("/visit")
    public ResponseEntity<VisitHistoryEntity> getVisit(/*@RequestParam Long visit_id*/) {
        return ResponseEntity.ok(visitService.getVisit(UserInfo.VISIT_ID));
    }
}
