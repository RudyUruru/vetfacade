package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.vetfacade.dto.AppointmentDTO;
import com.project.vetfacade.dto.AppointmentStatus;
import com.project.vetfacade.dto.AppointmentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentEntity{
    private Long appointment_id;
    private String doctor_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;
    private AppointmentType type;
    private String description;
    private PetLightEntity pet;
    private AppointmentStatus status;

    public static AppointmentEntity toEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointment_id(dto.getAppointment_id());
        entity.setDate(dto.getDate());
        entity.setDoctor_name(dto.getDoctor_name());
        entity.setType(dto.getType());
        entity.setPet(PetLightEntity.toEntity(dto.getPet()));
        entity.setDescription(dto.getDescription());
        if (entity.getDate().isAfter(LocalDateTime.now()))
            entity.setStatus(AppointmentStatus.WAITING);
        else
            entity.setStatus(AppointmentStatus.COMPLETED);
        return entity;
    }
    public AppointmentEntity() {
    }
}
