package com.ms.plantilla.commsplantilla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Usuarios", version = "1.0", description = "Documentación de la API de Usuarios"))
public class ComMsPlantillaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComMsPlantillaApplication.class, args);
	}

}
