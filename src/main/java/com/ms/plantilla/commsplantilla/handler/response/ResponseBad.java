package com.ms.plantilla.commsplantilla.handler.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBad {
    private final String codigo;
    private final String mensaje;
    private final String folio;
    private final List<String> detalles;
}
