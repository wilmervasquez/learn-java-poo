package com.wvl.semana03.ejercicio01;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    AreaTriangulo objeto = new AreaTriangulo();

    objeto.setLadoA(3.6);
    objeto.setLadoB(4.0);
    objeto.setLadoC(5.0);

    objeto.mostrarResultado();

    // Ejemplo 2
    AreaTriangulo objeto2 = new AreaTriangulo(16.5, 9.0, 20.0);

    objeto2.mostrarResultado();
  }
}
