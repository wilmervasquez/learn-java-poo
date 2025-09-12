package com.wvl.semana03.ejercicio03;

// 1.13. TEOREMA DEL COSENO
public class TeoremaDelCoseno {
  Double ladoB;
  Double ladoC;
  Double alfa; // en radianes

  Double calcularLadoDesconocido() {
    return Math.sqrt(
      Math.pow(ladoB, 2) +
      Math.pow(ladoC, 2) -
      2 * ladoB * ladoC * Math.cos(alfa)
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Lado desconocido): " + calcularLadoDesconocido());
  }
}
