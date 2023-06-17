package com.project.vetfacade.bisentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkTimeEntity {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("free_time")
    private List<LocalDateTime> freeTimeList = new ArrayList<>();
    public static WorkTimeEntity toEntity(List<LocalDateTime> freeTimeList) {
        WorkTimeEntity entity = new WorkTimeEntity();
        entity.setFreeTimeList(freeTimeList);
        return entity;
    }
}
