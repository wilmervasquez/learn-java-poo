package com.wvl.algoritmos.ejercicio10;

// 1.20. CONVERSIÓN DE GRADOS CELSIUS A FARENHEIT, KELVIN Y RANKINE
public class ConversorDeTemperatura {
  private Double gradosCelsius;

  public ConversorDeTemperatura() {}
  public ConversorDeTemperatura(Double gradosCelsius) {
    this.gradosCelsius = gradosCelsius;
  }

  public Double getGradosCelsius() {
    return gradosCelsius;
  }

  public void setGradosCelsius(Double gradosCelsius) {
    this.gradosCelsius = gradosCelsius;
  }

  Double convertirAFarenheit() {
    return (getGradosCelsius() * 9/5) + 32;
  }

  Double convertirAKelvin() {
    return getGradosCelsius() + 273.15;
  }

  Double convertirARankine() {
    return (9/5) * getGradosCelsius() + 492;
  }

  void mostrarResultados() {
    System.out.println("Grados Celsius: " + gradosCelsius + "°");
    System.out.println("Farenheit: " + convertirAFarenheit());
    System.out.println("Kelvin: " + convertirAKelvin());
    System.out.println("Rankine: " + convertirARankine());
  }
}