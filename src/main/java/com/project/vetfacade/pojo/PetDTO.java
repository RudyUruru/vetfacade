package com.project.vetfacade.pojo;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
public class PetDTO {


    private Long pet_id;

    private String name;

    private BreedDataDTO breed;

    private DictionariesDataDTO sex;

    private LocalDateTime birthday;

    private Short sterilized;

    private TreesDataDTO kind;


    private String chipNumber;

    private DictionariesDataDTO color;

    private ClientDTO owner;

    private List<AppointmentDTO> appointments;

    private List<VisitDTO> visits;

    private List<XPetsDiagsDTO> diagnoses;
}
