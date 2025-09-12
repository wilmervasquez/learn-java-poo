package com.wvl.semana03.ejercicio01;

// 1.11. ÁREA DE UN TRIÁNGULO EN FUNCIÓN DEL SEMIPERÍMETRO
public class AreaTriangulo {
  Double ladoA;
  Double ladoB;
  Double ladoC;
  Double semiperimetro;

  Double calcularArea() {
    semiperimetro = (ladoA + ladoB + ladoC) / 2;
    return Math.sqrt(
      semiperimetro *
      (semiperimetro - ladoA) *
      (semiperimetro - ladoB) *
      (semiperimetro - ladoC)
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Area): " + calcularArea());
  }
}
