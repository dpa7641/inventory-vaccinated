package com.challenge.inventoryvaccinated.model.repository.user;

import com.challenge.inventoryvaccinated.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value =  "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllVo();


    @Query(value = "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u WHERE u.name = :nameUser ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByName(@Param("nameUser") String nameUser);

    @Query(value = "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u WHERE u.id_rol = :idRol ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllUserVoByRol(@Param("idRol") int idRol);
    
    @Query(value = "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u WHERE u.vaccinated = :vaccinated ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByVaccinated(@Param("vaccinated") Boolean vaccinated);

    @Query(value = "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u, inventory.vaccination v \n" +
            "WHERE u.vaccinated = true and v.id_vaccine = :id \n" +
            "ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByVaccine(@Param("id") int id);

    @Query(value = "SELECT u.id, u.name, u.last_name, u.ci, u.email, u.birthdate, u.phone, u.vaccinated, u.id_rol,\n" +
            "(SELECT r.name FROM usuario.rol r WHERE u.id_rol = r.id) rol_name\n" +
            "FROM usuario.user u, inventory.vaccination v \n" +
            "WHERE u.vaccinated = true and v.date > :init and v.date < :end \n" +
            "ORDER BY u.id DESC", nativeQuery = true)
    List<Object[]> findAllVoByVaccinationDate(@Param("init") Date init, @Param("end") Date end);
}
