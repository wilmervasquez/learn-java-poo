package com.wvl.semana03.ejercicio01;

public class Main {
  public static void main(String[] args) {
    AreaTriangulo objeto = new AreaTriangulo();

    objeto.establecerLadoA(3.6);
    objeto.establecerLadoB(4.0);
    objeto.establecerLadoC(5.0);

    objeto.mostrarResultado();
  }
}
