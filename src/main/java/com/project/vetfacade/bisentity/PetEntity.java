package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.vetfacade.pojo.PetDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetEntity {
    private Long pet_id;
    private ColorEntity color;
    private boolean sterilized;
    private String name;
    private BreedEntity breed;
    private SexEntity sex;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime birthday;
    private KindEntity kind;
    @JsonProperty("chip_number")
    private String chipNumber;



    public PetEntity() {
    }

    public static PetEntity toEntity(PetDTO dto) {
        PetEntity entity = new PetEntity();
        entity.setPet_id(dto.getPet_id());
        if (dto.getColor() != null) {
            entity.setColor(ColorEntity.toEntity(dto.getColor()));
        }
        if (dto.getSterilized() != null) {
            entity.setSterilized(true);
        }
        entity.setName(dto.getName());
        if (dto.getBreed() != null) {
            entity.setBreed(BreedEntity.toEntity(dto.getBreed()));
        }
        entity.setSex(SexEntity.toEntity(dto.getSex()));
        if (dto.getBirthday() != null) {
            entity.setBirthday(dto.getBirthday());
        }
        if (dto.getChipNumber() != null) {
            entity.setChipNumber(dto.getChipNumber());
        }
        entity.setKind(KindEntity.toEntity(dto.getKind()));
        return entity;
    }
}
