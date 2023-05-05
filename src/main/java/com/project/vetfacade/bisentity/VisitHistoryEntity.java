package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.DiagnosesDTO;
import com.project.vetfacade.pojo.VisitDTO;
import com.project.vetfacade.pojo.VisitType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VisitHistoryEntity {
    private Long visit_id;
    private PetEntity pet;
    private List<AnalysisEntity> analyzes = new ArrayList<>();
    private List<DiagnosesDTO> diagnoses = new ArrayList<>();
    private String prescription;
    private LocalDateTime date;
    private String recommendation;
    private VisitType type;
    private Long first_visit_id;
    public static VisitHistoryEntity toEntity(VisitDTO dto) {
        VisitHistoryEntity entity = new VisitHistoryEntity();
        entity.setVisit_id(dto.getVisit_id());
        entity.setPet(PetEntity.toEntity(dto.getPet()));
        entity.setDate(dto.getDate());
        entity.getAnalyzes().add(new AnalysisEntity());
        dto.getDiagnoses().forEach(xPetsDiagnosis -> entity.getDiagnoses().add(xPetsDiagnosis.getDiagnosis()));
        entity.setPrescription(dto.getPrescription());
        entity.setRecommendation(dto.getRecommendation());
        switch(dto.getType()) {
            case 101: entity.setType(VisitType.FIRST); break;
            case 102: entity.setType(VisitType.SECONDARY); break;
            case 112: entity.setType(VisitType.VACCINATION); break;
        }
        entity.setFirst_visit_id(dto.getFirst_visit_id());
        return entity;
    }
}
