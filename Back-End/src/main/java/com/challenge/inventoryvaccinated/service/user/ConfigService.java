package com.challenge.inventoryvaccinated.service.user;


import com.challenge.inventoryvaccinated.model.entity.user.Config;
import com.challenge.inventoryvaccinated.model.pojo.user.vo.ConfigVo;

import java.util.List;
import java.util.Optional;

/**
 * Servicio interface para la entidad Usuario de sus diferentes interacciones
 * @author Daniel Puña
 * @version 1.0
 */
public interface ConfigService {

  /**
     * Obtiene un listado de todos los usuarios para seguridad en la DB
     * @return el listado de todos los usuarios
     */
    List<ConfigVo> findAllVo();

    /**
     * Busqueda mediante parametro ID de un usuario
     *
     * @param id : del objeto buscado en la base de datos
     * @return el usuario solicitado mediante parametro
     */
    Optional<Config> findById(int id);

  /**
   * Busqueda mediante parametro ID de un usuario
   *
   * @param id : del objeto buscado en la base de datos
   * @return el usuario solicitado mediante parametro
   */
  Optional<Config> findByIdUser(int id);

    /**
     * Actualizacion de datos de la entidad requerida
     * @param "Usuario": la entidad extraida de la tabla en DB
     * @return actualizacion de los datos en la DB
     */
    void update(Config entity);

    /**
     * Eliminacion del usuario dada por parametro identificador
     * @param "Usuario": la entidad extraida de la tabla en DB
     * @return eliminacion del usuario dentro de la DB
     */
    void delete(Config entity);
}
