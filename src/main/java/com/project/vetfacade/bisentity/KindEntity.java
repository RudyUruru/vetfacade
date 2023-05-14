package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.TreesDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KindEntity {
    private Long kind_id;
    private String kind_name;
    public static KindEntity toEntity(TreesDataDTO dto) {
        KindEntity entity = new KindEntity();
        entity.setKind_id(dto.getId());
        entity.setKind_name(dto.getValue());
        return entity;
    }

    //Переопределил чтобы в FiltersService Set правильно сравнивал
    @Override
    public int hashCode() {
        return kind_id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        KindEntity entity = (KindEntity) obj;
        return this.kind_id == entity.kind_id;
    }
}
