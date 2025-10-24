package com.wvl.emc;

public class Main {
  public static String encriptar(String texto, int desplazamiento) {
    String password = "";
    texto = texto.toUpperCase();

    for (int i = 0; i < texto.length(); i++) {
      char c = texto.charAt(i);

      if (c >= 'A' && c <= 'Z') {
        char letraCifrada = (char)(((c - 'A' + desplazamiento) % 26) + 'A');
        password += letraCifrada;
      } else {
        password = password + c;
      }
      System.out.println(c);
    }
    return password;
  }

  public static void main(String[] args) {
    System.out.println(Main.encriptar("FAMILY",1));
    
    System.out.println((char)65);
  }
}
