package com.wvl.arreglos;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int opcion, indice;

    Numeros numeros = new Numeros(6);

    do {
      System.out.println("--- Munu de Opciones ---");

      System.out.println("Ingrese 1 para Agregar: ");
      System.out.println("Ingrese 2 para Listar: ");
      System.out.println("Ingrese 3 para Buscar: ");
      System.out.println("Ingrese 4 para Editar: ");
      System.out.println("Ingrese 5 para Eliminar: ");
      System.out.println("Ingrese 6 para Salir: ");

      System.out.print("Ingrese una opcion: ");
      opcion = scanner.nextInt();

      switch (opcion) {
        case 0:

          break;
        case 1:
          System.out.println("--- Agregar ---");

          for (int i = 0; i < numeros.getLenght(); i++) {
            System.out.print("numeros[" + i + "] = ");
            numeros.setNumero(i, scanner.nextInt());
          }

          break;
        case 2:
          System.out.println("--- Listar ---");

          for (int i = 0; i < numeros.getLenght(); i++) {
            System.out.println("numeros[" + i + "] = " + numeros.getNumero(i));
          }

          break;
        case 3:
          System.out.println("--- Buscar ---");

          System.out.print("Ingrese el numero a buscar: ");
          int numeroABuscar = scanner.nextInt();

          indice = numeros.buscar(numeroABuscar);

          if (indice == -1) {
            System.out.println("El numero no existe");
          } else {
            System.out.println("numeros[" + indice + "] = " + numeros.getNumero(indice));
          }

          break;
        case 4:
          System.out.println("--- Editar ---");
          System.out.print("Ingrese el indice: ");
          indice = scanner.nextInt();
          System.out.print("Ingrese el numero: ");
          int numero = scanner.nextInt();

          numeros.setNumero(indice, numero);
          break;
        case 5:
          System.out.println("--- Eliminar ---");
          System.out.print("Ingrese el indice: ");
          indice = scanner.nextInt();

          numeros.eliminar(indice);

          break;
        default:
          System.out.println("--- Salir ---");
          break;
      }

    } while (opcion != 6);

    scanner.close();
  }
}

