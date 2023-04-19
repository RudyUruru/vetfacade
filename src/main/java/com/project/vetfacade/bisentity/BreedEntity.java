package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.BreedDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BreedEntity {
    private Long breed_id;
    private String breed_name;
    public static BreedEntity toEntity(BreedDataDTO dto) {
        BreedEntity entity = new BreedEntity();
        entity.setBreed_id(dto.getBreed_id());
        entity.setBreed_name(dto.getValue());
        return entity;
    }

    //Переопределил чтобы в FiltersService Set правильно сравнивал
    @Override
    public int hashCode() {
        return breed_id.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        BreedEntity entity = (BreedEntity) obj;
        return this.breed_id == entity.breed_id;
    }
}
