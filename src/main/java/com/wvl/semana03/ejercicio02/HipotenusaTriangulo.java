package com.wvl.semana03.ejercicio02;

// 1.12. HIPOTENUSA DE UN TRIÁNGULO RECTÁNGULO
public class HipotenusaTriangulo {
  Double ladoA;
  Double ladoB;

  void establecrLadoA (Double lado) { ladoA = lado; }
  void establecrLadoB (Double lado) { ladoB = lado; }

  Double obtenerLadoA () { return ladoA; }
  Double obtenerLadoB () { return ladoB; }

  Double calcularHipotenusa() {
    return Math.sqrt(Math.pow(obtenerLadoA(), 2) + Math.pow(obtenerLadoB(), 2));
  }

  void mostrarResultado() {
    System.out.println("Resultado(Hipotenusa): " + calcularHipotenusa());
  }
}