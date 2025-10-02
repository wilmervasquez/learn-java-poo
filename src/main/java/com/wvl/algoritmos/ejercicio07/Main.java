package com.wvl.algoritmos.ejercicio07;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    LeyDeSenos objeto = new LeyDeSenos();

    objeto.setLadoC(10.0);
    objeto.setAlfa(Math.toRadians(30));
    objeto.setBeta(Math.toRadians(45));
    objeto.setGamma(Math.toRadians(105));

    objeto.mostrarResultado();

    // Ejemplo 2
    LeyDeSenos objeto2 = new LeyDeSenos(10.0, Math.toRadians(50), Math.toRadians(45), Math.toRadians(85));

    objeto2.mostrarResultado();
  }
}
