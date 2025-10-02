package com.wvl.algoritmos.ejercicio07;

// 1.17. LEY DE SENOS
public class LeyDeSenos {
  private Double ladoC;
  // angulos opuestos a los lados en radianes
  private Double alfa;
  private Double beta;
  private Double gamma;

  LeyDeSenos() { }
  LeyDeSenos(Double ladoC, Double alfa, Double beta, Double gamma) {
    this.ladoC = ladoC;
    this.alfa = alfa;
    this.beta = beta;
    this.gamma = gamma;
  }

  void setLadoC(Double ladoC) { this.ladoC = ladoC; }
  void setAlfa(Double alfa) { this.ladoC = alfa; }
  void setBeta(Double beta) { this.beta = beta; }
  void setGamma(Double gamma) { this.gamma = gamma; }

  Double getLadoC() { return this.ladoC; }
  Double getAlfa() { return this.alfa; }
  Double getBeta() { return this.beta; }
  Double getGamma() { return this.gamma; }

  Double calcularLadoA() {
    return (getLadoC() / Math.sin(getAlfa())) * Math.sin(getGamma());
  }

  Double calcularLadoB() {
    return (getLadoC() / Math.sin(getBeta())) * Math.sin(getGamma());
  }

  void mostrarResultado() {
    System.out.println("Resultado:");
    System.out.println("Lado A: " + calcularLadoA());
    System.out.println("Lado B: " + calcularLadoB());
  }
}
