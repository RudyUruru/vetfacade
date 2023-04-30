package com.project.vetfacade.bisentity;


import com.project.vetfacade.pojo.DiagnosesDTO;
import com.project.vetfacade.pojo.VisitDTO;
import com.project.vetfacade.pojo.VisitType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class VisitEntity {

    private Long visit_id;
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
        entity.setType(dto.getType());
        entity.setFirst_visit_id(dto.getFirst_visit_id());
        return entity;
    }
    public VisitEntity() {}
}
