package com.wvl.semana03.ejercicio06;

// 1.16. MONTO A DEVOLVER POR UN CAPITAL PRESTADO
public class Prestamo {
  Double capital;
  Double tasaDeInteres;
  Integer periodos;

  Double calcularMontoADevolver() {
    return capital * (1 + tasaDeInteres) * periodos;
  }

  void mostrarResultado() {
    System.out.println("Resultado(Monto a devolver): " + calcularMontoADevolver());
  }
}
