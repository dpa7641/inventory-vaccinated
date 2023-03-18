package com.challenge.inventoryvaccinated.model.entity.inventory;

import com.challenge.inventoryvaccinated.model.SchemaDB;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = SchemaDB.INVENTORY, name = "vaccination")

public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Past
    private Date date;
    private int doses;
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @NotNull
    @Column(name = "id_vaccine")
    private int idVaccine;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

}
