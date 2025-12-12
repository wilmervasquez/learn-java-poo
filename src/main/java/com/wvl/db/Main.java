package com.wvl.db;

import java.sql.Connection;

public class Main {
  public static void main(String[] args) {
    Scan sc = new Scan();
    char y;

    Connection connection= MySqlDb.connect();
    ClientController controller = new ClientController(connection);
    if (connection == null) {
      System.out.println("No se ha podido conectar a la base de datos");
      return;
    }

    int option;
    do {
      System.out.println("MENU");
      System.out.println("1) Agregar un cliente");
      System.out.println("2) Mostrar clientes");
      System.out.println("3) Agregar un cliente");
      System.out.println("4) Agregar un cliente");
      System.out.println("5) Agregar un cliente");
      System.out.println("6) Agregar un cliente");
      System.out.println("7) Agregar un cliente");
      System.out.println("8) Agregar un cliente");
      option = sc.nextInt("Seleccione una opcion: ");

      switch (option) {
        case 1 -> {
          Client client = new Client();
          client.name = sc.next("\uDB80\uDDA7 Nombre: ");
          client.lastName = sc.next("\uDB80\uDDA7 Last Name: ");
          client.dni = sc.next("\uDB80\uDDA7 DNI: ");
          client.email = sc.next("\uDB80\uDDA7 Email: ");
          client.phone = sc.next("\uDB80\uDDA7 Phone(9): ");
          client.address = sc.next("\uDB80\uDDA7 Address: ");

          controller.create(client);
        }
        case 2 -> {
          for (Client client: controller.geAllClients()) {
            System.out.println("\u001B[31m\uF084 \u001B[32m" + client.id + " \u001B[33m" + client.name + " \u001B[34m" + client.email);
          }
        }
      }

      y = sc.next("\u001B[32mDesea continuar(S/N)?: ").charAt(0);
    } while (y == 's' || y == 'S');
  }
}
