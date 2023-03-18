package com.challenge.inventoryvaccinated.model.entity.user;

import com.challenge.inventoryvaccinated.model.SchemaDB;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = SchemaDB.USUARIO, name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private int ci;
    private String email;
    private Date birthdate;
    private int phone;
    private boolean vaccinated;
    @Column(name = "id_rol")
    private int idRol;

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
