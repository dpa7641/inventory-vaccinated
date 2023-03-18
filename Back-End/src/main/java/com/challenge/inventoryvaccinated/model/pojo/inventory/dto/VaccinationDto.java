package com.challenge.inventoryvaccinated.model.pojo.inventory.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class VaccinationDto {

    private Date date;
    private int doses;
    private int idUser;
    private int idVaccine;
}
