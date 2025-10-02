package com.wvl.algoritmos.ejercicio09;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    ConversionDeAngulo objeto = new ConversionDeAngulo();

    objeto.setGrado(30.0);
    objeto.setMinuto(15.0);
    objeto.setSegundo(50.0);

    objeto.mostrarResultados();

    // Ejemplo 2
    ConversionDeAngulo objeto2 = new ConversionDeAngulo(30.0, 15.0, 50.0);

    objeto2.mostrarResultados();
  }
}
