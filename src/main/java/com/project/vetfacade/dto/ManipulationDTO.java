package com.project.vetfacade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManipulationDTO {
    private Long id;
    private TreesDataDTO category;
    private String name;
}
