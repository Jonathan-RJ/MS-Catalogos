package com.ms.plantilla.commsplantilla.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ms.plantilla.commsplantilla.dto.request.UsuarioRequestDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @PostMapping
    public ResponseEntity<String> crearUsuario(@Valid @RequestBody UsuarioRequestDto usuario) {
        LOGGER.info("comienza proceso ...init pollo" + MDC.get("traceId"));
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    @GetMapping("/p")
    public String getMethodName() {
        return "holis";
    }
}
