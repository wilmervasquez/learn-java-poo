package com.wvl.semana03.ejercicio03;

// 1.13. TEOREMA DEL COSENO
public class TeoremaDelCoseno {
  Double ladoB;
  Double ladoC;
  Double alfa; // en radianes

  void establecerLadoA(Double b) { ladoB = b; }
  void establecerLadoC(Double c) { ladoC = c; }
  void establecerAlfa(Double angulo) { alfa = angulo; }

  Double ontenerLadoB () { return ladoB; }
  Double ontenerLadoC () { return ladoC; }
  Double obtenerAlfa() { return alfa; }

  Double calcularLadoDesconocido() {
    return Math.sqrt(
      Math.pow(ontenerLadoB(), 2) +
      Math.pow(ontenerLadoC(), 2) -
      2 * ladoB * ladoC * Math.cos(obtenerAlfa())
    );
  }

  void mostrarResultado() {
    System.out.println("Resultado(Lado desconocido): " + calcularLadoDesconocido());
  }
}
