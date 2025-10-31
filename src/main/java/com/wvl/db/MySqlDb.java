package com.wvl.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDb {
  private static final String URL = "jdbc:mysql://localhost:3306/dealership";
  private static final String USER = "root";
  private static final String PASSWORD = "1234";

  public static Connection connect() {
    try {
      Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("✅ Conectado correctamente a MySQL");
      return conexion;
    } catch (SQLException e) {
      System.out.println("❌ Error de conexión: " + e.getMessage());
      return null;
    }
  }
}
