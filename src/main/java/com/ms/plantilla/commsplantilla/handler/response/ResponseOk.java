package com.ms.plantilla.commsplantilla.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseOk {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String mensaje;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String folio;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Object resultado;
}
