package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.ConfigurationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ConfigurationEntity {
    private String address;
    private CoordinatesEntity coordinates;
    //TODO добавить информацию в бд о координатах
    public static ConfigurationEntity toEntity(ConfigurationDTO dto) {
        ConfigurationEntity entity = new ConfigurationEntity();
        entity.coordinates = new CoordinatesEntity();
        entity.coordinates.setLongitude("55.883822");
        entity.coordinates.setLatitude("37.536953");
        entity.setAddress("127411 Москва ул. Учинская д.6");
        return entity;
    }

    public ConfigurationEntity() {
        this.coordinates = new CoordinatesEntity();
        coordinates.setLongitude("55.883822");
        coordinates.setLatitude("37.536953");
        this.setAddress("127411 Москва ул. Учинская д.6");
    }
}
