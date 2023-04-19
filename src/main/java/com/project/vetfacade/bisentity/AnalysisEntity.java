package com.project.vetfacade.bisentity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//TODO найти инфомрацию по анализам в БД и реализацивать
//тут пока заглушка
public class AnalysisEntity {
    private Long analysis_id;
    private String doctor_name;
    private boolean ready;
    private String analysis_name;
    private Long visit_id;
    public static AnalysisEntity toEntity() {
        AnalysisEntity entity = new AnalysisEntity();
        entity.setAnalysis_id(1L);
        entity.setDoctor_name("Мстислав");
        entity.setReady(false);
        entity.setAnalysis_name("Прививка от бешенства");
        entity.setVisit_id(14L);
        return entity;
    }
    public AnalysisEntity(){
        this.setAnalysis_id(1L);
        this.setDoctor_name("Мстислав");
        this.setReady(false);
        this.setAnalysis_name("Прививка от бешенства");
        this.setVisit_id(14L);
    }
}
