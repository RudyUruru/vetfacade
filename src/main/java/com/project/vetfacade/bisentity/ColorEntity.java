package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.DictionariesDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorEntity {
    private Long color_id;
    private String color_name;
    public static ColorEntity toEntity(DictionariesDataDTO dto) {
        ColorEntity entity = new ColorEntity();
        entity.setColor_id(dto.getId());
        entity.setColor_name(dto.getValue());
        return entity;
    }
}
