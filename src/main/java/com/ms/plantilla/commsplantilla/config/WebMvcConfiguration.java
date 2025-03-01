package com.ms.plantilla.commsplantilla.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Archivo con las configuraciones de WebMvcConfigurer
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
  // variable para interceptar las peticiones
  @Autowired
  private RequestTimeInterceptor requestTime;

  /**
   * Constructor sin parametros
   */
  public WebMvcConfiguration() {
    // constructor vacio
  }

  /**
   * Constructor con parametros
   *
   * @param requestTime tiempo
   */
  public WebMvcConfiguration(RequestTimeInterceptor requestTime) {
    this.requestTime = requestTime;
  }

  /**
   * metodo
   *
   * @param registry
   */
  public void addInterceptors(InterceptorRegistry registry) {
    // registra
    registry.addInterceptor((HandlerInterceptor) this.requestTime);
  }
}
