package com.project.vetfacade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class VisitSimpleDTO {

    private Long visit_id;



    private Long petId;


    private Long clientId;

    private LocalDateTime date;

    private String anamnesis;

    private String prescription;

    private String recommendation;

    private Integer type;

    private Long first_visit_id;

    private String weight;

    private String temperature;

    private String heartBeat;

    private String breathBeat;

    private DictionariesDataDTO vaccine;

    private LocalDateTime nextVaccination;

}
