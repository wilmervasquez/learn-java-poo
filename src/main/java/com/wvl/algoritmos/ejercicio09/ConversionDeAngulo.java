package com.wvl.algoritmos.ejercicio09;

// 1.19. CONVERSIÓN DEL SEXAGESIMAL U°V’W’’ A GRADOS, MINUTOS Y SEGUNDOS CENTESIMALES
public class ConversionDeAngulo {
  Double grado; // grados sexagesimales del ángulo
  Double minuto; // minutos sexagesimales del ángulo
  Double segundo; // segundos sexagesimales del ángulo

  Double calcularValorEnGradosCentesimales() {
    return 10 * (grado + minuto / 60 + segundo / 3600) / 9;
  }

  Double convertirAGradosCentesimales() {
    return Math.floor(calcularValorEnGradosCentesimales());
  }

  Double convertirAMinutosCentesimales() {
    return Math.floor((calcularValorEnGradosCentesimales() - convertirAGradosCentesimales()) * 100);
  }

  Double convertirASegundosCentesimales() {
    return ((calcularValorEnGradosCentesimales() - convertirAGradosCentesimales()) * 100 - convertirAMinutosCentesimales()) * 100;
  }

  void mostrarResultados() {
    System.out.println("El angulo en centesimales equivale a: ");
    System.out.println(convertirAGradosCentesimales() + "° " + convertirAMinutosCentesimales() + "' " + convertirASegundosCentesimales() + "\"");
  }
}
