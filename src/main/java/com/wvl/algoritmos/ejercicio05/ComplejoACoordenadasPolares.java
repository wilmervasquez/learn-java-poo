package com.wvl.algoritmos.ejercicio05;

// 1.15. CONVERTIR COMPLEJO C = A + B A COORDENADAS POLARES
public class ComplejoACoordenadasPolares {
  private Double real;
  private Double imaginaria;

  ComplejoACoordenadasPolares() {}

  ComplejoACoordenadasPolares(Double real, Double imaginaria) {
    this.real = real;
    this.imaginaria = imaginaria;
  }

  void setReal(Double real) { this.real = real; }
  void setImaginaria(Double imaginaria) { this.imaginaria = imaginaria; }

  Double getReal() { return this.real; }
  Double getImaginaria() { return this.imaginaria; }

  Double calcularModulo() {
    return Math.sqrt(getReal() * getReal() + getImaginaria() * getImaginaria());
  }

  Double calcularAngulo() {
    return Math.atan(getImaginaria() / getReal());
  }

  void mostrarResultado() {
    Double angulo = calcularAngulo();
    System.out.println("Resultado: " + calcularModulo() + "(cos(" + angulo + "), sen(" + angulo + "))");
  }
}
