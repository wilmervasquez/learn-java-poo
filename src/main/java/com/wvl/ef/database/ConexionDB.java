package com.wvl.ef.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
  private static final String URL = "jdbc:mysql://localhost:3306/poo";
  private static final String USER = "root";
  private static final String PASSWORD = "1234";

  private static Connection connection;

  public static Connection getConnection() {
    try {
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      return connection;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
