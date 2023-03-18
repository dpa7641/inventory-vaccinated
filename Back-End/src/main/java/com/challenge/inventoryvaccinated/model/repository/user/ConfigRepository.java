package com.challenge.inventoryvaccinated.model.repository.user;

import com.challenge.inventoryvaccinated.model.entity.user.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Integer> {

  @Query(value =  "SELECT c.id, c.username, c.id_user, \n" +
          "(SELECT u.name FROM usuario.user u WHERE c.id_user = u.id) name,\n" +
          "(SELECT u.email FROM usuario.user u WHERE c.id_user = u.id) email\n" +
          "FROM usuario.config c ORDER BY c.id DESC", nativeQuery = true)
  List<Object[]> findAllVo();

  @Query(value =  "SELECT * FROM usuario.config c WHERE c.id_user = :idUser ORDER BY c.id DESC", nativeQuery = true)
  Optional<Config> findByIdUser(@Param("idUser") int idUser);
}
