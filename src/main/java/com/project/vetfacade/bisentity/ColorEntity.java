package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.DictionariesDataDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
