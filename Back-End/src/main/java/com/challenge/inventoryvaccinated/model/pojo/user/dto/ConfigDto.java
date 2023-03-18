package com.challenge.inventoryvaccinated.model.pojo.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigDto {

    private String username;
    private String password;
    private Boolean enabled;
    private int idUser;
}
