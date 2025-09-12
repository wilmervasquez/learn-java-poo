package com.wvl.semana03.ejercicio03;

public class Main {

  public static void main(String[] args) {
    TeoremaDelCoseno objeto = new TeoremaDelCoseno();

    objeto.ladoB = 6.0;
    objeto.ladoC = 9.0;
    objeto.alfa = 0.5235; // 30°

    objeto.mostrarResultado();
  }
}
