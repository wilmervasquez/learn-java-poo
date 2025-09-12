package com.wvl.semana03.ejercicio05;

// 1.15. CONVERTIR COMPLEJO C = A + B A COORDENADAS POLARES
public class ComplejoACoordenadasPolares {
  Double real;
  Double imaginaria;

  Double calcularModulo() {
    return Math.sqrt(real * real + imaginaria * imaginaria);
  }

  Double calcularAngulo() {
    return Math.atan(imaginaria / real);
  }

  void mostrarResultado() {
    Double angulo = calcularAngulo();
    System.out.println("Resultado: " + calcularModulo() + "(cos(" + angulo + "), sen(" + angulo + "))");
  }
}
