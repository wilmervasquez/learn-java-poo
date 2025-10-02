package com.wvl.algoritmos.ejercicio03;

// 1.13. TEOREMA DEL COSENO
public class TeoremaDelCoseno {
  private Double ladoB;
  private Double ladoC;
  private Double alfa; // en radianes

  public TeoremaDelCoseno() { }

  public TeoremaDelCoseno(Double ladoB, Double ladoC, Double alfa) {
    setLadoB(ladoB);
    setLadoC(ladoC);
    setAlfa(alfa);
  }

  public void setLadoB(Double ladoB) { this.ladoB = ladoB; }
  public void setLadoC(Double ladoC) { this.ladoC = ladoC; }
  public void setAlfa(Double alfa) { this.alfa = alfa; }

  public Double getLadoB() { return ladoB; }
  public Double getLadoC() { return ladoC; }
  public Double getAlfa() { return alfa; }

  Double calcularLadoDesconocido() {
    return Math.sqrt(
      Math.pow(getLadoB(), 2) +
      Math.pow(getLadoC(), 2) -
      2 * ladoB * ladoC * Math.cos(getAlfa())
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Lado desconocido): " + calcularLadoDesconocido());
  }
}
