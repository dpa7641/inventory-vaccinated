package com.challenge.inventoryvaccinated.service.user;

import com.challenge.inventoryvaccinated.model.entity.user.Rol;
import com.challenge.inventoryvaccinated.model.pojo.user.dto.RolDto;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.RolVo;

import java.util.List;
import java.util.Optional;

/**
 * Servicio interface para la entidad Rol de sus diferentes interacciones
 * @author Daniel Puña
 * @version 1.0
 */
public interface RolService {

    /**
     * Obtiene un listado de todos los roles en la DB
     * @return el listado de todos los roles
     */
    List<RolVo> findAllVo();

    /**
     * Busqueda mediante parametro ID de un rol
     * @param id: del rol buscado en la base de datos
     * @return el rol solicitado mediante parametro si existe
     */
    Optional<Rol> findById(int id);



    /**
     * Busqueda por parametro nombre del Rol
     * @param name: parametro con el nombre del rol
     * @return roles que contengan el parametro
     */
    List<RolVo> findAllVoByName(String name);

    /**
     * Almacenamiento de un nuevo rol
     * @param "rol": pojo dto la entidad
     * @return guardado en la BD en la respectiva tabla
     */
    Rol persist(RolDto dto);

    /**
     * Actualizacion de datos de la entidad requerida por parametro
     * @param "Rol": la entidad extraida de la tabla en DB
     * @return actualizacion de los datos en la DB
     */
    void update(Rol entity);

    /**
     * Eliminacion del rol dada por parametro identificador
     * @param "Rol": la entidad extraida de la tabla en DB
     * @return eliminacion del rol dentro de la DB
     */
    void delete(Rol entity);
}
