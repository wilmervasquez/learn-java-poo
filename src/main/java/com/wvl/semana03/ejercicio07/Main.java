package com.wvl.semana03.ejercicio07;

public class Main {
  public static void main(String[] args) {
    LeyDeSenos objeto = new LeyDeSenos();

    objeto.ladoC = 10.0;
    objeto.alfa = Math.toRadians(30);
    objeto.beta = Math.toRadians(45);
    objeto.gamma = Math.toRadians(60);

    objeto.mostrarResultado();
  }
}
