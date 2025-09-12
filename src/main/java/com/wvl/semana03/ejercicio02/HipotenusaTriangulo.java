package com.wvl.semana03.ejercicio02;

// 1.12. HIPOTENUSA DE UN TRIÁNGULO RECTÁNGULO
public class HipotenusaTriangulo {
  Double ladoA;
  Double ladoB;

  Double calcularHipotenusa() {
    return Math.sqrt(Math.pow(ladoA, 2) + Math.pow(ladoB, 2));
  }

  void mostrarResultado() {
    System.out.println("Resultado(Hipotenusa): " + calcularHipotenusa());
  }
}