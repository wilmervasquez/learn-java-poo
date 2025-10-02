package com.wvl.algoritmos.ejercicio09;

// 1.19. CONVERSIÓN DEL SEXAGESIMAL U°V’W’’ A GRADOS, MINUTOS Y SEGUNDOS CENTESIMALES
public class ConversionDeAngulo {
  private Double grado; // grados sexagesimales del ángulo
  private Double minuto; // minutos sexagesimales del ángulo
  private Double segundo; // segundos sexagesimales del ángulo

  ConversionDeAngulo() {}
  public ConversionDeAngulo(Double grado, Double minuto, Double segundo) {
    this.grado = grado;
    this.minuto = minuto;
    this.segundo = segundo;
  }

  public Double getGrado() {
    return grado;
  }

  public void setGrado(Double grado) {
    this.grado = grado;
  }

  public Double getMinuto() {
    return minuto;
  }

  public void setMinuto(Double minuto) {
    this.minuto = minuto;
  }

  public Double getSegundo() {
    return segundo;
  }

  public void setSegundo(Double segundo) {
    this.segundo = segundo;
  }

  Double calcularValorEnGradosCentesimales() {
    return 10 * (getGrado() + getMinuto() / 60 + getSegundo() / 3600) / 9;
  }

  Double convertirAGradosCentesimales() {
    return Math.floor(calcularValorEnGradosCentesimales());
  }

  Double convertirAMinutosCentesimales() {
    return Math.floor((calcularValorEnGradosCentesimales() - convertirAGradosCentesimales()) * 100);
  }

  Double convertirASegundosCentesimales() {
    return ((calcularValorEnGradosCentesimales() - convertirAGradosCentesimales()) * 100 - convertirAMinutosCentesimales()) * 100;
  }

  void mostrarResultados() {
    System.out.println("El angulo en centesimales equivale a: ");
    System.out.println(convertirAGradosCentesimales() + "° " + convertirAMinutosCentesimales() + "' " + convertirASegundosCentesimales() + "\"");
  }
}
