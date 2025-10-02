package com.wvl.algoritmos.ejercicio04;

public class Main {

  public static void main(String[] args) {
    // Ejemplo 1
    DistanciaDePuntos objeto = new DistanciaDePuntos();

    objeto.setX1(2.0);
    objeto.setY1(2.0);
    objeto.setX2(2.0);
    objeto.setY2(2.0);

    objeto.mostrarResultado();

    // Ejemplo 2
    DistanciaDePuntos objeto2 = new DistanciaDePuntos(2.0, -6.0,  23.0,87.0);
    objeto2.calcularDistancia();
  }
}
