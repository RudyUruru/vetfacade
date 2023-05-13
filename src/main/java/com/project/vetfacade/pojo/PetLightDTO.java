package com.project.vetfacade.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PetLightDTO {

    private Long pet_id;

    private String name;

    private BreedDataDTO breed;

    private TreesDataDTO kind;

    private DictionariesDataDTO sex;

    private LocalDateTime birthday;

    private String chipNumber;

    private Short sterilized;

    private ClientDTO owner;

    private DictionariesDataDTO color;
}
