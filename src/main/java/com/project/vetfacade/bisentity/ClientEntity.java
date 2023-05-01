package com.project.vetfacade.bisentity;

import com.project.vetfacade.pojo.ClientDTO;
import com.project.vetfacade.pojo.ClientLightDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientEntity {
    private Long client_id;
    private String name;
    private String middle_name;
    private String surname;
    private String phone;
    private String email;


    public ClientEntity() {
    }

    public static ClientEntity toEntity(ClientLightDTO dto) {
        ClientEntity entity = new ClientEntity();
        entity.setClient_id(dto.getClient_id());
        entity.setName(dto.getFirst_name());
        entity.setMiddle_name(dto.getMiddle_name());
        entity.setSurname(dto.getSur_name());
        entity.setPhone("9997772233");
        entity.setEmail("sss@mail.ru");
        return entity;
    }
}
