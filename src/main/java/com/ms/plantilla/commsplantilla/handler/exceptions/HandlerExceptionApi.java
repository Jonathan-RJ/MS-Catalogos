package com.ms.plantilla.commsplantilla.handler.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException401;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException404;
import com.ms.plantilla.commsplantilla.handler.exceptions.collections.HandlerRequestException500;
import com.ms.plantilla.commsplantilla.handler.response.ResponseBad;

@RestControllerAdvice
public class HandlerExceptionApi {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }

        ResponseBad responseBad = new ResponseBad(
                "400",
                "Error en la validación de la solicitud " + errores,
                MDC.get("traceId"),
                Arrays.asList("Errror"));

        return new ResponseEntity<>(responseBad, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { HandlerRequestException401.class })
    public ResponseEntity<Object> handlerRequestException401(HandlerRequestException401 e) {
        ResponseBad responseBad = new ResponseBad(
                e.getCodigo(),
                e.getMensaje(),
                e.getInformacion(),
                e.getDetalles());
        return new ResponseEntity<>(responseBad, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { HandlerRequestException404.class })
    public ResponseEntity<Object> handlerRequestException404(HandlerRequestException404 e) {
        ResponseBad responseBad = new ResponseBad(
                e.getCodigo(),
                e.getMensaje(),
                e.getInformacion(),
                e.getDetalles());
        return new ResponseEntity<>(responseBad, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { HandlerRequestException500.class })
    public ResponseEntity<Object> handlerRequestException500(HandlerRequestException500 e) {
        ResponseBad responseBad = new ResponseBad(
                e.getCodigo(),
                e.getMensaje(),
                e.getInformacion(),
                e.getDetalles());
        return new ResponseEntity<>(responseBad, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
