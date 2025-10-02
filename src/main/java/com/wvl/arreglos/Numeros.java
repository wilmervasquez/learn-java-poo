package com.wvl.arreglos;

public class Numeros {
  private int[] numeros;
  Numeros(int n) {
    numeros = new int[n];
  }

  void setNumero(int i, int numero) {
    if (i >= 0 && i < numeros.length) {
      numeros[i] = numero;
    }
  }

  int getNumero(int i) {
    if (i >= 0 && i < numeros.length) {
      return numeros[i];
    }
    return 0;
  }

  int getLenght() {
    return numeros.length;
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
      int[] tmp = new int[numeros.length - 1];

      int j = 0;
      for (int i = 0; i < numeros.length; i++) {
        if (i != indice) {
          tmp[j++] = numeros[i];
        }
      }
      numeros = tmp;
    }
  }
}
