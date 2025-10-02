package com.wvl.algoritmos.ejercicio06;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    Prestamo objeto = new Prestamo();

    objeto.setCapital(15000.0);
    objeto.setTasaDeInteres(0.09);
    objeto.setPeriodos(5);

    objeto.mostrarResultado();

    // Ejemplo 2
    Prestamo objeto2 = new Prestamo(16000.0, 0.07, 4);

    objeto2.mostrarResultado();
  }
}
