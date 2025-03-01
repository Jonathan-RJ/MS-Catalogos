package com.ms.plantilla.commsplantilla.handler.exceptions.collections;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HandlerRequestException400 extends RuntimeException {
    private final String codigo;
    private final String mensaje;
    private final String informacion;
    private final List<String> detalles;
}
