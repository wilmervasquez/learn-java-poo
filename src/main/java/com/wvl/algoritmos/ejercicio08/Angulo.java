package com.wvl.algoritmos.ejercicio08;

// 1.18. CONVERSIÓN DE GRADOS SEXAGESIMALES A CENTESIMALES Y RADIANES
public class Angulo {
  private Double grados;

  Angulo() {}
  Angulo(Double grados) {
    this.grados = grados;
  }

  void setGrados(Double grados) { this.grados = grados; }

  Double getGrados() { return this.grados; }

  Double convertirACentesimales() {
    return getGrados() * (10.0 / 9.0);
  }

  Double convertirARadianes() {
    return 180 / (Math.PI * getGrados());
  }

  void mostrarResultados() {
    System.out.println("Grados: " + grados);
    System.out.println("Centesimales: " + convertirACentesimales());
    System.out.println("Radianes: " + convertirARadianes());
  }
}

