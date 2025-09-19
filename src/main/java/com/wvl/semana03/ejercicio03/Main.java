package com.wvl.semana03.ejercicio03;

public class Main {

  public static void main(String[] args) {
    // Ejemplo 1
    TeoremaDelCoseno objeto = new TeoremaDelCoseno();

    objeto.setLadoB(10.0);
    objeto.setLadoC(10.0);
    objeto.setAlfa(Math.PI / 3); // 60°

    objeto.mostrarResultado();

    // Ejemplo 2
    TeoremaDelCoseno objeto2 = new TeoremaDelCoseno(23.0, 56.9, Math.PI / 2);

    objeto2.mostrarResultado();
  }
}
