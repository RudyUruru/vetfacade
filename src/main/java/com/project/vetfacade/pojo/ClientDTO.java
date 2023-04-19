package com.project.vetfacade.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private Long client_id;

    private String first_name;

    private String middle_name;

    private String sur_name;

    private String phone;

    private String email;

    private List<PetDTO> pets;

    private List<AppointmentDTO> appointments;

    private List<VisitDTO> visits;

}