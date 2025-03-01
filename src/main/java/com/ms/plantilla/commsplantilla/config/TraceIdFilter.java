package com.ms.plantilla.commsplantilla.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class TraceIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String traceId = UUID.randomUUID().toString(); // Generamos un ID único
        MDC.put("traceId", traceId); // Guardamos en el contexto de logs

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("X-Trace-Id", traceId); // Enviamos el traceId en la respuesta

        try {
            chain.doFilter(request, response); // Continuamos con la ejecución de la petición
        } finally {
            MDC.clear(); // Limpiamos al final para evitar que afecte a otras peticiones
        }
    }
}
