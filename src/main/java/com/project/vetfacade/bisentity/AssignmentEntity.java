package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.XPetsDiagsDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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
