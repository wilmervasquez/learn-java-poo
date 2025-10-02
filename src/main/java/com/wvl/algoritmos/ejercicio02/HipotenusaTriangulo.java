package com.wvl.algoritmos.ejercicio02;

// 1.12. HIPOTENUSA DE UN TRIÁNGULO RECTÁNGULO
public class HipotenusaTriangulo {
  private Double ladoA;
  private Double ladoB;

  public HipotenusaTriangulo() { }

  public HipotenusaTriangulo(Double ladoA, Double ladoB) {
    setLadoA(ladoA);
    setLadoB(ladoB);
  }

  void setLadoA (Double lado) { ladoA = lado; }
  void setLadoB (Double lado) { ladoB = lado; }

  Double getLadoA () { return ladoA; }
  Double getLadoB () { return ladoB; }

  Double calcularHipotenusa() {
    return Math.sqrt(Math.pow(getLadoA(), 2) + Math.pow(getLadoB(), 2));
  }

  void mostrarResultado() {
    System.out.println("Resultado(Hipotenusa): " + calcularHipotenusa());
  }
}