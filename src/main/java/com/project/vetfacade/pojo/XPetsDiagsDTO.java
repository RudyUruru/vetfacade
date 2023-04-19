package com.project.vetfacade.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class XPetsDiagsDTO {

    private PetDTO pet;

    private VisitDTO visit;

    private DiagnosesDTO diagnosis;

}
