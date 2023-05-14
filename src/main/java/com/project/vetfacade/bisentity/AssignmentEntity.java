package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.XPetsDiagsDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignmentEntity {

    private String diagnosis;
    private String prescription;
    public static AssignmentEntity toEntity(XPetsDiagsDTO dto) {
        AssignmentEntity entity = new AssignmentEntity();
        entity.setDiagnosis(dto.getDiagnosis().getDiagnosis_name());
        entity.setPrescription(dto.getVisit().getPrescription());
        return entity;
    }
    public AssignmentEntity() {}
}
