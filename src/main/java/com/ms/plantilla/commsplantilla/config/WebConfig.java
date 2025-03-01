package com.ms.plantilla.commsplantilla.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // Configurar la política de intercambio de recursos de origen cruzado (CORS)
    registry.addMapping("/**")
        // Permitir acceso desde cualquier origen
        .allowedOrigins("*")
        // Permitir los métodos GET, POST, PUT, DELETE y OPTIONS
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
        // Permitir todos los encabezados
        .allowedHeaders("*")
        // No permitir el envío de credenciales
        .allowCredentials(false);
  }

}
