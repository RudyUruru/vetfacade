package com.project.vetfacade.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {

    private Long appointment_id;

    private PetLightDTO pet;

    private ClientDTO client;

    private LocalDateTime date;

    private String value;

    private String doctor_name;
}
