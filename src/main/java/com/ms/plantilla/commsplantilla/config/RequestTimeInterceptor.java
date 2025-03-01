package com.ms.plantilla.commsplantilla.config;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ms.plantilla.commsplantilla.utils.Utilerias;

import java.util.Locale;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestTimeInterceptor implements HandlerInterceptor {
  private static final Logger LOGGER = LoggerFactory.getLogger(RequestTimeInterceptor.class);
  private Utilerias utilerias;

  /**
   * Metodo contructor con parametro para iniciar
   * 
   * @param utilerias clase utilerias
   */
  public RequestTimeInterceptor(Utilerias utilerias) {
    this.utilerias = utilerias;
  }

  /**
   * Método que se ejecuta antes de que el controlador maneje la solicitud
   * 
   * @param request  Request de la peticion
   * @param response Response de la peticion
   * @param handler  Handler
   */
  @Override
  public boolean preHandle(HttpServletRequest request,
      HttpServletResponse response, Object handler) throws Exception {
    // Crea un ID de registro único y establece el tiempo de inicio
    createIdLog();
    // imprime un log inidicandoe el inicio de la peticion
    LOGGER.info("----INICIA EL LLAMADO AL RECURSO :" + request.getRequestURI() + "----");
    return true;
  }

  /**
   * Método que se ejecuta después de que el controlador maneje la solicitud y la
   * respuesta se haya completado
   * 
   * @param request  Request de la peticion
   * @param response Response de la peticion
   * @param handler  Handler
   * @param ex       Exception
   */
  @Override
  public void afterCompletion(HttpServletRequest request,
      HttpServletResponse response, Object handler, Exception ex) {
    String tiempoInicial = MDC.get("inicioTiempoT");

    if (tiempoInicial != null) {
      // tiempo
      long tiempoI = Long.parseLong(tiempoInicial);
      // Calcula y establece el tiempo total de ejecución
      tiempoTotal(obtenerTiempo() - tiempoI);
    } else {
      LOGGER.info("NO hace nada");
    }
    // Obtiene el estado HTTP de la respuesta
    HttpStatus status = obtenerPorStatus(response.getStatus());
    // Finaliza la petición del llamado del recurso
    LOGGER.info("----TERMINA EL LLAMADO AL RECURSO :" + request.getRequestURI() + "----" + status.value());
    // Elimina los valores de tiempo y UUID del registro
    removerTotal();
  }

  /**
   * Método para establecer el tiempo total de ejecución en el registro
   * 
   * @param total tiempo total
   */
  private void tiempoTotal(long total) {
    // se agrega a MDC
    MDC.put("tiempo", "" + total);
  }

  /**
   * Método para eliminar los valores de tiempo y UUID del registro
   */
  private void removerTotal() {
    // remuve el tiempo
    MDC.remove("tiempo");
    // remueve el unique id
    MDC.remove("UUID");
  }

  /**
   * Método para crear un ID de registro único y establecer el tiempo de inicio
   */
  private void createIdLog() {
    //
    String uuid = UUID.randomUUID().toString().toLowerCase(Locale.ROOT);
    // agrega el inique id
    MDC.put("UUID", utilerias.myReplaceAll(uuid, "-", ""));
    // agrega el tiempo de inicio
    MDC.put("inicioTiempoT", "" + obtenerTiempo());
  }

  /**
   * Método para obtener el tiempo actual
   * 
   * @return tiempo en currentTimeMillis
   */
  private static long obtenerTiempo() {
    // retorna el tiempo
    return System.currentTimeMillis();
  }

  /**
   * Método para obtener el estado HTTP correspondiente al código de estado
   * proporcionado
   * 
   * @param codigo codigo actual
   * @return codigo http
   */
  private HttpStatus obtenerPorStatus(int codigo) {
    for (HttpStatus http : HttpStatus.values()) {
      // validamos que exista el codigo
      if (http.value() == codigo) {
        // retorna el codigo http
        return http;
      }
    }
    // retorna un codigo htpp 500
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
