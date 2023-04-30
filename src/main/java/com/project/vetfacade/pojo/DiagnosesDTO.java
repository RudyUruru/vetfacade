package com.project.vetfacade.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiagnosesDTO {

    private Long diagnosis_id;

    private String diagnosis_name;

    private TreesDataDTO diagnosis_type;
}
