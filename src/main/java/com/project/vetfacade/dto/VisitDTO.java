package com.project.vetfacade.dto;

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

    private PetLightDTO pet;

    private ClientDTO client;

    private LocalDateTime date;

    private String anamnesis;

    private String prescription;

    private String recommendation;

    private Integer type;

    private Long first_visit_id;

    private List<XPetsDiagsDTO> diagnoses;

    private String weight;

    private String temperature;

    private String heartBeat;

    private String breathBeat;

    private Long vaccineId;

    private LocalDateTime nextVaccination;

}