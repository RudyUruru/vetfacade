package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.vetfacade.dto.VisitDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//тут пока заглушка
public class AnalysisEntity {

    @JsonProperty("analysis_id")
    private Long analysisId;


    private PetLightEntity pet;


    private VisitEntity visit;


    @JsonProperty("analysis_name")
    private String analysisName;


    @JsonProperty("is_ready")
    private boolean isReady;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;
    public static AnalysisEntity toEntity() {
        AnalysisEntity entity = new AnalysisEntity();
        PetLightEntity pet = new PetLightEntity();
        pet.setName("Кеша");
        entity.setAnalysisId(1L);
        entity.setPet(pet);
        VisitDTO visit = new VisitDTO();
        visit.setVisit_id(130L);
        entity.setVisit(VisitEntity.toEntity(visit));
        entity.setAnalysisName("Анализ крови");
        entity.setDate(LocalDateTime.of(2023, 1, 12, 1, 30));
        entity.setReady(true);
        return entity;
    }

}
