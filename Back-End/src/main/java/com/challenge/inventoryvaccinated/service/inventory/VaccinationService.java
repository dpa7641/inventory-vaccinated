package com.challenge.inventoryvaccinated.service.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccination;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccinationDto;
import com.challenge.inventoryvaccinated.model.pojo.inventory.vo.VaccinationVo;

import java.util.List;
import java.util.Optional;

/**
 * Servicio interface para la entidad vaccination de sus diferentes interacciones
 * @author Daniel Puña
 * @version 1.0
 */

public interface VaccinationService {

    /**
     * Obtiene un listado de todos las vacunaciones de los empleados la DB
     * @return el listado de todas las vacunaciones
     */
    List<VaccinationVo> findAllVo();

    /**
     * Busqueda mediante parametro ID de una vacunacion
     * @param id: del objeto buscado en la base de datos
     * @return la vacunacion solicitado mediante parametro
     */
    Optional<Vaccination> findById(int id);


    /**
     * Almacenamiento de una nueva vacunacion mediante una actualizacion de daros del usuario
     * @param "VaccinationDTO": entidad del pojo la entidad
     * @return guardado en la BD
     */
    Vaccination persistByUpdate(int id, VaccinationDto dto);

    /**
     * Busqueda de las vacunaciones realizadas a un usuario
     * @param id: identificados del usuario
     * @param id: numero de dosis realizada pos el usuario
     * @return el registro de la vacunacion solizitada mediante los dos parametros
     */
    Optional <Vaccination> finByIdByDoses(int id, int doses);


    /**
     * Almacenamiento de un nueva vacunaion de manera separada por un usuario
     * @param "VaccinationDTO": pojo la entidad
     * @return guardado en la BD
     */
    Vaccination persist(VaccinationDto dto);

    /**
     * Actualizacion de datos de una vacunacion
     * @return actualizacion en la BD
     */
    void update(Vaccination entity);


    /**
     * Eliminacion del registro de una vacunacion
     * @param "Vaccination": la entidad extraida de la tabla en DB
     * @return eliminacion dentro de la DB
     */
    void delete(Vaccination entity);

}
