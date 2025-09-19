package com.wvl.semana03.ejercicio02;

public class Main {
  public static void main(String[] args) {
    // Ejemplo 1
    HipotenusaTriangulo objeto = new HipotenusaTriangulo();

    objeto.setLadoA(12.0);
    objeto.setLadoB(6.0);

    objeto.mostrarResultado();

    // Ejemplo 2
    HipotenusaTriangulo objeto2 = new HipotenusaTriangulo(12.0, 9.0);

    objeto2.mostrarResultado();
  }
}
