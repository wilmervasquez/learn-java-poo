package com.wvl.algoritmos.ejercicio05;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    ComplejoACoordenadasPolares objeto = new ComplejoACoordenadasPolares();

    objeto.setReal(45.0);
    objeto.setImaginaria(30.4);

    objeto.mostrarResultado();

    // Ejemplo 2
    ComplejoACoordenadasPolares objeto2 = new ComplejoACoordenadasPolares(12.0, 5.0);

    objeto2.mostrarResultado();
  }
}
