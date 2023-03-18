package com.challenge.inventoryvaccinated.model.pojo.user.dto;

import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccinationDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {

    private String name;
    private String lastName;
    private int ci;
    private String email;
    private Date birthdate;
    private int phone;
    private Boolean vaccinated;
    private int idRol;
    private VaccinationDto vacuna;
}
