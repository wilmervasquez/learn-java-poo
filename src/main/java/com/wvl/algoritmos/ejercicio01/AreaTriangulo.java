package com.wvl.algoritmos.ejercicio01;

// 1.11. ÁREA DE UN TRIÁNGULO EN FUNCIÓN DEL SEMIPERÍMETRO
public class AreaTriangulo {
  private Double ladoA;
  private Double ladoB;
  private Double ladoC;

  public AreaTriangulo() { }

  public AreaTriangulo(Double ladoA, Double ladoB, Double ladoC) {
    setLadoA(ladoA);
    setLadoB(ladoB);
    setLadoC(ladoC);
  }

  void setLadoA(Double lado) { ladoA = lado;}
  void setLadoB(Double lado) { ladoB = lado;}
  void setLadoC(Double lado) { ladoC = lado;}

  Double getLadoA() { return ladoA;}
  Double getLadoB() { return ladoB;}
  Double getLadoC() { return ladoC;}

  Double getSemiperimetro() {
    return (ladoA + ladoB + ladoC) / 2;
  }

  Double calcularArea() {
    Double semiperimetro = getSemiperimetro();
    return Math.sqrt(
      semiperimetro *
      (semiperimetro - getLadoA()) *
      (semiperimetro - getLadoB()) *
      (semiperimetro - getLadoC())
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Area): " + calcularArea());
  }
}
