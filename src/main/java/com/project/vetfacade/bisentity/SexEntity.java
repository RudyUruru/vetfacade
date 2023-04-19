package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.DictionariesDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SexEntity {
    private Long sex_id;
    private String sex_name;
    public static SexEntity toEntity(DictionariesDataDTO dto) {
        SexEntity entity = new SexEntity();
        entity.setSex_id(dto.getId());
        entity.setSex_name(dto.getValue());
        return entity;
    }
}
