package com.wvl.semana03.ejercicio03;

public class Main {

  public static void main(String[] args) {
    TeoremaDelCoseno objeto = new TeoremaDelCoseno();

    objeto.establecerLadoA(10.0);
    objeto.establecerLadoC(10.0);
    objeto.establecerAlfa(Math.PI / 3); // 60°

    objeto.mostrarResultado();
  }
}
