package com.challenge.inventoryvaccinated.model.pojo.user.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVo {

    private int id;
    private String name;
    private String lastName;
    private int ci;
    private String email;
    private Date birthdate;
    private int phone;
    private boolean vaccinated;
    private int idRol;
    private String rolName;
}
