package com.project.vetfacade.controller;

import com.project.vetfacade.dto.AppointmentType;
import com.project.vetfacade.service.AppointmentService;
import com.project.vetfacade.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
    /*private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);*/

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/make_appointment")
    public ResponseEntity makeAppointment(@AuthenticationPrincipal User user,
                                          @RequestParam("pet_id") Long petId,
                                          @RequestParam LocalDateTime date,
                                          @RequestParam("surgeon_id") Long surgeonId,
                                          @RequestParam AppointmentType type) {
        return appointmentService.makeAppointment(user.getEmail(), petId, date, surgeonId,type);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity handleBadRequest(WebClientResponseException e){
        return ResponseEntity.badRequest().body("Appointment on this time already exist");
    }

    /*@ExceptionHandler({MissingServletRequestParameterException.class, })
    public ResponseEntity handleMissParam(MissingServletRequestParameterException e,  HttpServletRequest request) {
        String query = request.getQueryString();
        logger.info("query: " + query);
        return ResponseEntity.badRequest().body("query: " + query);
    }*/
    /*@Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeHeaders(false);
        return loggingFilter;
    }*/
}
