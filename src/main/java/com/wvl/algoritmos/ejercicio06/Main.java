package com.wvl.algoritmos.ejercicio06;

public class Main {
  public static void main(String[] args) {
    Prestamo objeto = new Prestamo();

    objeto.capital = 15000.0;
    objeto.tasaDeInteres = 0.09; 
    objeto.periodos = 5; 

    objeto.mostrarResultado();
  }
}
