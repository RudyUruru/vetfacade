package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.vetfacade.dto.DiagnosesDTO;
import com.project.vetfacade.dto.VisitDTO;
import com.project.vetfacade.dto.VisitType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitHistoryEntity {
    private Long visit_id;
    private PetLightEntity pet;
    private List<AnalysisEntity> analyzes = new ArrayList<>();
    private List<DiagnosesDTO> diagnoses = new ArrayList<>();
    private String prescription;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;
    private String recommendation;
    private VisitType type;
    @JsonProperty("first_visit_id")
    private Long firstVisitId;

    private String weight;

    private String temperature;

    @JsonProperty("heart_beat")
    private String heartBeat;

    @JsonProperty("breath_beat")
    private String breathBeat;

    @JsonProperty("vaccine_id")
    private Long vaccineId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("next_vaccination")
    private LocalDateTime nextVaccination;
    public static VisitHistoryEntity toEntity(VisitDTO dto) {
        VisitHistoryEntity entity = new VisitHistoryEntity();
        entity.setVisit_id(dto.getVisit_id());
        entity.setPet(PetLightEntity.toEntity(dto.getPet()));
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
        entity.setFirstVisitId(dto.getFirst_visit_id());
        entity.setWeight(dto.getWeight());
        entity.setHeartBeat(dto.getHeartBeat());
        entity.setBreathBeat(dto.getBreathBeat());
        entity.setTemperature(dto.getTemperature());
        entity.setVaccineId(dto.getVaccineId());
        entity.setNextVaccination(dto.getNextVaccination());
        return entity;
    }
}
