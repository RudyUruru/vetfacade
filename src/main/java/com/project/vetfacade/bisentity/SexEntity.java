package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.DictionariesDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
