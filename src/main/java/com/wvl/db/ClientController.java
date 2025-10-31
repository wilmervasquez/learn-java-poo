package com.wvl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientController {
  Connection connection;
  ClientController(Connection connection) {
    this.connection = connection;
  }

  public ArrayList<Client> geAllClients() {
    try {
      String sql = "SELECT * FROM clients";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      ArrayList<Client> clients = new ArrayList<>();

      while (rs.next()) {
        Client client = new Client();
        client.id = rs.getInt("id");
        client.name = rs.getString("name");
        client.email = rs.getString("email");
        clients.add(client);
      }
      return clients;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void create(Client client) {
    try {
      String sql = "INSERT INTO clients (name, last_name, dni, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, client.name);
      ps.setString(2, client.lastName);
      ps.setString(3, client.dni);
      ps.setString(4, client.email);
      ps.setString(5, client.phone);
      ps.setString(6, client.address);
      // ps.setInt(2, 22);

      int filas = ps.executeUpdate();
      System.out.println("\uF058 Se insertaron " + filas + " filas.");

      connection.close();
    } catch (Exception e) {
      System.out.println("❌ Error al insertar: " + e.getMessage());
    }
  }
}
