package com.challenge.inventoryvaccinated.service.inventory;

import com.challenge.inventoryvaccinated.model.entity.inventory.Vaccine;
import com.challenge.inventoryvaccinated.model.pojo.inventory.dto.VaccineDto;
import com.challenge.inventoryvaccinated.model.pojo.inventory.vo.VaccineVo;

import java.util.List;
import java.util.Optional;

/**
 * Servicio interface para la entidad vaccine de sus diferentes interacciones
 * @author Daniel Puña
 * @version 1.0
 */
public interface VaccineService {

    /**
     * Obtiene un listado de todos las vacunas en la DB
     * @return el listado de todas las vacunas
     */
    List<VaccineVo> findAllVo();

    /**
     * Busqueda mediante parametro ID una vacuna
     * @param id: del objeto buscado en la base de datos
     * @return si existe, el dato solicitado mediante parametro
     */
    Optional<Vaccine> findById(int id);

    /**
     * Busqueda por parametro nombre de las vacunas
     * @param name: parametro con el nombre solicitada
     * @return listado de vacunas que contengan el parametro
     */
    List<VaccineVo> findAllVoByName(String name);


    /**
     * Almacenamiento de una nueva vacuna
     * @param "VaccineDTO": pojo la entidad
     * @return guardado en la BD
     */
    Vaccine persist(VaccineDto dto);

    /**
     * Actualizacion de datos de la entidad
     * @param "vaccine": la entidad extraida de la tabla en DB
     * @return actualizacion de datos en la DB
     */
    void update(Vaccine entity);

    /**
     * Eliminacion de una vacuna dado por parametro identificador
     * @param "Vaccine": la entidad extraida de la tabla en DB
     * @return eliminacion de la vacuna dentro de la DB
     * Si la vacuna llega a tener alguna vacunacion de algun usuario
     * la misma no podra ser eliminada sin antes eliminar los demas registros
     */
    void delete(Vaccine entity);
}
