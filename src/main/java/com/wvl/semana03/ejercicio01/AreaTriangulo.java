package com.wvl.semana03.ejercicio01;

// 1.11. ÁREA DE UN TRIÁNGULO EN FUNCIÓN DEL SEMIPERÍMETRO
public class AreaTriangulo {
  Double ladoA;
  Double ladoB;
  Double ladoC;

  void establecerLadoA(Double lado) { ladoA = lado;}
  void establecerLadoB(Double lado) { ladoB = lado;}
  void establecerLadoC(Double lado) { ladoC = lado;}

  Double obtenerLadoA() { return ladoA;}
  Double obtenerLadoB() { return ladoB;}
  Double obtenerLadoC() { return ladoC;}

  Double obtenerSemiperimetro () {
    return (ladoA + ladoB + ladoC) / 2;
  }

  Double calcularArea() {
    Double semiperimetro = obtenerSemiperimetro();
    return Math.sqrt(
      semiperimetro *
      (semiperimetro - obtenerLadoA()) *
      (semiperimetro - obtenerLadoB()) *
      (semiperimetro - obtenerLadoC())
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Area): " + calcularArea());
  }
}
