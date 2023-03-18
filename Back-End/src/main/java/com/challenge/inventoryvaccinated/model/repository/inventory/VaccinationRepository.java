package com.challenge.inventoryvaccinated.model.repository.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {

    @Query(value =  "SELECT * FROM inventory.vaccination v WHERE v.id_user = :idUser and v.doses = :idDoses", nativeQuery = true)
    Optional<Vaccination> finByIdByDoses(@Param("idUser") int idUser, @Param("idDoses") int idDoses);

    @Query(value =  "SELECT v.id, v.date, v.doses, v.id_user, v.id_vaccine, \n" +
    "(SELECT u.name FROM usuario.user u WHERE v.id_user = u.id) user_name, \n" +
    "(SELECT va.name FROM inventory.vaccine va WHERE v.id_vaccine = va.id ) vaccine_name \n" +
    "FROM inventory.vaccination v ", nativeQuery = true)
    List<Object[]> findAllVo();
}

