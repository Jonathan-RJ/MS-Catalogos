package com.ms.plantilla.commsplantilla.utils;

import org.springframework.stereotype.Component;

@Component
// clase para utilerias, metodos que se ocupan mucho
public class Utilerias {
  /**
   * Mi metodo que reemplaza todos los caracteres
   *
   * @param valor           Cadena original
   * @param valorAEncontrar texto que se quiere identificar
   * @param valorRemplazar  texto que se quiere cambiar
   * @return
   */
  public String myReplaceAll(String valor,
      String valorAEncontrar,
      String valorRemplazar) {
    // se guarda el valor en una nueva variable
    String nValor = valor;
    // validamos que valor contenga el valor a buscar
    if (valor.contains(valorAEncontrar)) {
      // si se encuentra se reemplza el valor
      nValor = valor.replace(valorAEncontrar, valorRemplazar);
      // y despues de vuelve a invocar el metodo para encontrar otra coincidencia
      nValor = myReplaceAll(nValor, valorAEncontrar, valorRemplazar);
    }
    // se retorna el nuevo valor
    return nValor;
  }

}
