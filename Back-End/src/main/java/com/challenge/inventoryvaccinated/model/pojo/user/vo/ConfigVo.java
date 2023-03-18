package com.challenge.inventoryvaccinated.model.pojo.user.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigVo {

    private int id;
    private String username;
    private String password;
    private Boolean enabled;
    private int idUser;
    private String name;
    private String email;
}
