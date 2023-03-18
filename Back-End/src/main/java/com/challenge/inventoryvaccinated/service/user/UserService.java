package com.challenge.inventoryvaccinated.service.user;

import com.challenge.inventoryvaccinated.model.entity.user.User;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.UserDto;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.UserVo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Servicio interface para la entidad Usuario de sus diferentes interacciones
 * @author Daniel Puña
 * @version 1.0
 */
public interface UserService {

    /**
     * Obtiene un listado de todos los usuarios en la DB
     *
     * @return el listado de todos los usuarios
     */
    List<UserVo> findAllVo();

    /**
     * Busqueda mediante parametro ID de un usuario
     *
     * @param id : del objeto buscado en la base de datos
     * @return el usuario solicitado mediante parametro
     */
    Optional<User> findById(int id);


    /**
     * Busqueda por parametro nombre del usuario
     *
     * @param "name": parametro con el nombre del usuario
     * @return usuarios que contengan el parametro
     */
    List<UserVo> findAllVoByName(String name);

    /**
     * Busqueda por parametro de los usuarios si y no vacunados
     *
     * @param "vaccinated": parametro con el nombre del rol
     * @return usuarios que contengan el parametro
     * Este parametro es un booleano, por lo que los resultados dependeran de la situacion
     */
    List<UserVo> findAllVoByVaccinated(Boolean vaccinated);

    /**
     * Busqueda mediante parametro ID de un rol
     * @param id: del rol buscado en la base de datos
     * @return los usuarios que pertenescan a ese rol
     */
    List<UserVo> findAllByRol(int id);

    /**
     * Busqueda mediante parametro ID de una vacuna
     * @param id: del la vacuna buscado en la base de datos
     * @return los usuarios que estes vacunados con el Id de la misma
     */
    List<UserVo> findAllVoByVacccine(int id);

    /**
     * Busqueda de usuarios mediante  parametro
     * @param "init": parametro fecha de inicio de busqueda
     * @param "end": parametro fecha de finalizacion de busqueda
     * @return Vacunaciones efectuadas dentro de los parametros
     */
    List<UserVo> findAllVoByVaccinationDate(Date init, Date end);

    /**
     * Almacenamiento de un nuevo usuario
     * @param "UsuarioDTO": entidad pojo dto
     * @return guardado en la BD
     */
    User persist(UserDto dto);

    /**
     * Actualizacion de datos de la entidad requerida
     * @param "Usuario": la entidad extraida de la tabla en DB
     * @return actualizacion de los datos en la DB
     */
    void update(User user);

    /**
     * Eliminacion del usuario dada por parametro identificador
     * @param "Usuario": la entidad extraida de la tabla en DB
     * @return eliminacion del usuario dentro de la DB
     */
    void delete(User entity);
}
