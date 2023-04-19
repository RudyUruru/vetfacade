package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.AppointmentDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class AppointmentEntity{
    private Long appointment_id;
    private String doctor_name;
    private LocalDateTime date;
    private String type;
    private PetLightEntity pet;

    public static AppointmentEntity toEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointment_id(dto.getAppointment_id());
        entity.setDate(dto.getDate());
        entity.setDoctor_name(dto.getDoctor_name());
        entity.setType(dto.getValue());
        entity.setPet(PetLightEntity.toEntity(dto.getPet()));
        return entity;
    }
    public AppointmentEntity() {
    }
}
