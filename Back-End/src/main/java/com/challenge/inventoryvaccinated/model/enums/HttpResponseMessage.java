package com.challenge.inventoryvaccinated.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum HttpResponseMessage {
    FIND_SUCCESSFUL("Busqueda exitosa"),
    PERSIST_SUCCESSFUL("Se registro correctamente"),
    UPDATE_SUCCESSFUL("Se actualizo correctamente"),
    DELETE_SUCCESSFUL("Se elimino correctamente"),
    NOT_FOUND_RECORD("No se encontro el registro");

    private final String value;
}
