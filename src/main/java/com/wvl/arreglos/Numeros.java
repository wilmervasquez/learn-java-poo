package com.wvl.arreglos;

public class Numeros {
  private int n;
  private final int[] numeros;
  Numeros(int n) {
    numeros = new int[n];
    this.n = n;
  }

  void setNumero(int i, int numero) {
    if (i >= 0 && i < getLenght()) {
      numeros[i] = numero;
    }
  }

  int getNumero(int i) {
    if (i >= 0 && i < getLenght()) {
      return numeros[i];
    }
    return 0;
  }

  int getLenght() {
    return n;
  }

  int buscar(int numero) {
    for (int i = 0; i < getLenght(); i++) {
      if (numeros[i] == numero) {
        return i;
      }
    }

    return -1;
  }

  void eliminar(int indice) {
    if (indice >= 0 && indice < numeros.length) {
      for (int i = indice; i < n; i++) {
        numeros[i] = numeros[i+1];
      }
      n--;
    }
  }
}
