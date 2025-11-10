package com.wvl.market.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL {
  private static MySQL instance;
  private static Connection connection;
  private static final Logger logger = Logger.getLogger(MySQL.class.getName());

  // Datos de conexión
  private static final String URL = "jdbc:mysql://localhost:3306/market?useSSL=false&serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASSWORD = "1234"; // o "" si no tiene contraseña

  // Constructor privado (evita que se creen nuevas instancias)
  private MySQL() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      logger.info("\u001B[92m✅ Conexión exitosa a MySQL");
    } catch (ClassNotFoundException e) {
      logger.log(Level.SEVERE, "Error: No se encontró el driver de MySQL", e);
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Error al conectar con MySQL", e);
    }
  }

  // Método estático para obtener la instancia única
  public static MySQL getInstance() {
    if (instance == null) {
      instance = new MySQL();
    }
    return instance;
  }

  // Devuelve la conexión actual
  public Connection getConnection() {
    return connection;
  }

  // Cierra la conexión si está abierta
  public void close() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        logger.info("🔴 Conexión MySQL cerrada correctamente");
      }
    } catch (SQLException e) {
      logger.log(Level.WARNING, "Error al cerrar la conexión MySQL", e);
    }
  }
}
