package com.project.vetfacade.bisentity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.DiagnosesDTO;
import com.project.vetfacade.dto.VisitDTO;
import com.project.vetfacade.dto.VisitType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitEntity {

    private Long visit_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;
    private List<DiagnosesDTO> diagnoses;
    private PetEntity pet;
    private VisitType type;
    private Long first_visit_id;
    public static VisitEntity toEntity(VisitDTO dto) {
        VisitEntity entity = new VisitEntity();
        entity.setVisit_id(dto.getVisit_id());
        entity.setDiagnoses(new ArrayList<>());
        entity.setDate(dto.getDate());
        dto.getDiagnoses().forEach(xPetsDiagnosis -> entity.getDiagnoses().add(xPetsDiagnosis.getDiagnosis()));
        entity.setPet(PetEntity.toEntity(dto.getPet()));
        entity.setFirst_visit_id(dto.getFirst_visit_id());
        switch(dto.getType()) {
            case 101: entity.setType(VisitType.FIRST); break;
            case 102: entity.setType(VisitType.SECONDARY); break;
            case 112: entity.setType(VisitType.VACCINATION); break;
        }
        return entity;
    }
    public VisitEntity() {}
}
