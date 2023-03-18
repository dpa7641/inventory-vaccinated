package com.challenge.inventoryvaccinated.model.repository.user;

import com.challenge.inventoryvaccinated.model.entity.user.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query(value =  "SELECT r.id, r.name FROM usuario.rol r ORDER BY r.id DESC", nativeQuery = true)
    List<Object[]> findAllVo();

    @Query(value = "SELECT r.id, r.name FROM usuario.rol r WHERE r.name = :nameRol ORDER BY r.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByName(@Param("nameRol") String nameRol);


}
