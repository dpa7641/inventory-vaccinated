package com.challenge.inventoryvaccinated.model.repository.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {

    @Query(value =  "SELECT v.id, v.name FROM inventory.vaccine v ORDER BY v.id DESC", nativeQuery = true)
    List<Object[]> findAllVo();

    @Query(value = "SELECT v.id, v.name FROM inventory.vaccine v WHERE v.name = :name ORDER BY v.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByName(@Param("name") String name);

}
