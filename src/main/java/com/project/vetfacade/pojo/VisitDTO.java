package com.project.vetfacade.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class VisitDTO {
    private Long visit_id;

    private PetDTO pet;

    private ClientDTO client;

    private LocalDateTime date;

    private String anamnesis;

    private String prescription;

    private String recommendation;

    private List<XPetsDiagsDTO> diagnoses;

}