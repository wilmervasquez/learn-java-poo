package com.wvl.algoritmos.ejercicio06;

// 1.16. MONTO A DEVOLVER POR UN CAPITAL PRESTADO
public class Prestamo {
  private Double capital;
  private Double tasaDeInteres;
  private Integer periodos;

  Prestamo() {}
  Prestamo(Double capital, Double tasaDeInteres, Integer periodos) {
    this.capital = capital;
    this.tasaDeInteres = tasaDeInteres;
    this.periodos = periodos;
  }
  void setCapital(Double capital) { this.capital = capital; }
  void setTasaDeInteres(Double tasaDeInteres) {this.tasaDeInteres = tasaDeInteres; }
  void setPeriodos(Integer periodos) { this.periodos = periodos; }

  Double getCapital() { return this.capital; }
  Double getTasaDeInteres() { return this.tasaDeInteres; }
  Integer getPeriodos() { return this.periodos; }

  Double calcularMontoADevolver() {
    return getCapital() * (1 + getTasaDeInteres()) * getPeriodos();
  }

  void mostrarResultado() {
    System.out.println("Resultado(Monto a devolver): " + calcularMontoADevolver());
  }
}
