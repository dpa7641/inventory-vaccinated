package com.challenge.inventoryvaccinated.model.pojo.inventory.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class VaccinationVo {

    private int id;
    private Date date;
    private int doses;
    private int idUser;
    private int idVaccine;
    private String vaccineName;
    private String userName;
}
