package com.wvl.algoritmos.ejercicio08;

// 1.18. CONVERSIÓN DE GRADOS SEXAGESIMALES A CENTESIMALES Y RADIANES
public class Angulo {
  Double grados;

  Double convertirACentesimales() {
    return grados * (10.0 / 9.0);
  }

  Double convertirARadianes() {
    return 180 / (Math.PI * grados);
  }

  void mostrarResultados() {
    System.out.println("Grados: " + grados);
    System.out.println("Centesimales: " + convertirACentesimales());
    System.out.println("Radianes: " + convertirARadianes());
  }
}

