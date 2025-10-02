package com.wvl.algoritmos.ejercicio10;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    ConversorDeTemperatura objeto = new ConversorDeTemperatura();

    objeto.setGradosCelsius(57.0);

    objeto.mostrarResultados();

    // Ejemplo 2
    ConversorDeTemperatura objeto2 = new ConversorDeTemperatura(33.0);

    objeto2.mostrarResultados();
  }
}
