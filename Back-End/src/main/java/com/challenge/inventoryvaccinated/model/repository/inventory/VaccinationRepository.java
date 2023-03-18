package com.challenge.inventoryvaccinated.model.repository.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {

    @Query(value =  "SELECT v.id, v.doses, v.id_vaccine, v.id_user \n" +
            "FROM inventory.vaccination v WHERE v.id_user = :idUser and v.doses = :idDoses ", nativeQuery = true)
    Optional<Vaccination> finByIdByDoses(@Param("idUser") int idUser, @Param("idDoses") int idDoses);
}

