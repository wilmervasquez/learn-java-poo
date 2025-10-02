package com.wvl.algoritmos.ejercicio04;

// 1.14. DISTANCIA ENTRE DOS PUNTOS
public class DistanciaDePuntos {
  private Double x1;
  private Double y1;
  private Double x2;
  private Double y2;

  DistanciaDePuntos() { }
  DistanciaDePuntos(Double x1, Double y1, Double x2, Double y2) {
    setX1(x1);
    setY1(y1);
    setX2(x2);
    setY2(y2);
  }
  void setX1(Double n) { x1 = n; }
  void setY1(Double n) { y1 = n; }
  void setX2(Double n) { x2 = n; }
  void setY2(Double n) { y2 = n; }

  Double getX1() { return x1; }
  Double getY1() { return y1; }
  Double getX2() { return x2; }
  Double getY2() { return y2; }

  Double calcularDistancia() {
    return Math.sqrt(Math.pow(getX2() - getX1(), 2) + Math.pow(getY2() - getY1(), 2));
  }

  void mostrarResultado() {
    System.out.println("Resultado(Distancia): " + calcularDistancia());
  }
}
