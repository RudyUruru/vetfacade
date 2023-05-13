package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.PetLightDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class PetLightEntity {
    private Long pet_id;
    private ColorEntity color;
    private boolean sterilized;
    private SexEntity sex;
    private LocalDateTime birthday;
    private String name;
    private KindEntity kind;
    private BreedEntity breed;
    private String chip_number;

    public static PetLightEntity toEntity(PetLightDTO dto) {
        PetLightEntity entity = new PetLightEntity();
        entity.setPet_id(dto.getPet_id());
        if (dto.getColor() != null) {
            entity.setColor(ColorEntity.toEntity(dto.getColor()));
        }
        if (dto.getSterilized() != null) {
            entity.setSterilized(true);
        }
        entity.setSex(SexEntity.toEntity(dto.getSex()));
        if (dto.getBirthday() != null)
            entity.setBirthday(dto.getBirthday());
        entity.setName(dto.getName());
        entity.setKind(KindEntity.toEntity(dto.getKind()));
        if (dto.getChipNumber() != null) {
            entity.setChip_number(dto.getChipNumber());
        }
        if (dto.getBreed() != null) {
            entity.setBreed(BreedEntity.toEntity(dto.getBreed()));
        }
        return entity;
    }
}
