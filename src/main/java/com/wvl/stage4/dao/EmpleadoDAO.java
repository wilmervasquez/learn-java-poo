package com.wvl.stage4.dao;

import com.wvl.stage4.database.ConexionDB;
import com.wvl.stage4.models.Empleado;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

  private static final String INSERT =
  "INSERT INTO empleados (nombre, apellido, dni, telefono, cargo, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?)";

  private static final String SELECT_ALL = "SELECT * FROM empleados WHERE activo = 1";
  private static final String SELECT_BY_ID = "SELECT * FROM empleados WHERE id = ?";
  private static final String UPDATE =
  "UPDATE empleados SET nombre = ?, apellido = ?, dni = ?, telefono = ?, cargo = ?, fecha_contratacion = ? WHERE id = ?";
  private static final String DELETE = "UPDATE empleados SET cargo = 'Ninguno' , activo = 0 WHERE id = ?";

  public void insertar(Empleado empleado) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

      ps.setString(1, empleado.getNombre());
      ps.setString(2, empleado.getApellido());
      ps.setString(3, empleado.getDni());
      ps.setString(4, empleado.getTelefono());
      ps.setString(5, empleado.getCargo());
      ps.setDate(6, Date.valueOf(empleado.getFechaContratacion()));

      ps.executeUpdate();

      rs = ps.getGeneratedKeys();
      if (rs.next()) empleado.setId(rs.getInt(1));

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al insertar empleado: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }

  public Empleado obtenerPorId(int id) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Empleado empleado = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(SELECT_BY_ID);
      ps.setInt(1, id);

      rs = ps.executeQuery();

      if (rs.next()) {
        empleado = new Empleado(
        rs.getInt("id"),
        rs.getString("nombre"),
        rs.getString("apellido"),
        rs.getString("dni"),
        rs.getString("telefono"),
        rs.getString("cargo"),
        rs.getDate("fecha_contratacion").toLocalDate()
        );
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener empleado: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return empleado;
  }

  public List<Empleado> obtenerTodos() {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Empleado> empleados = new ArrayList<>();

    try {
      conn = ConexionDB.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(SELECT_ALL);

      while (rs.next()) {
        empleados.add(new Empleado(
        rs.getInt("id"),
        rs.getString("nombre"),
        rs.getString("apellido"),
        rs.getString("dni"),
        rs.getString("telefono"),
        rs.getString("cargo"),
        rs.getDate("fecha_contratacion").toLocalDate()
        ));
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener empleados: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return empleados;
  }

  // =========================
  // ACTUALIZAR
  // =========================
  public void actualizar(Empleado empleado) {

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(UPDATE);

      ps.setString(1, empleado.getNombre());
      ps.setString(2, empleado.getApellido());
      ps.setString(3, empleado.getDni());
      ps.setString(4, empleado.getTelefono());
      ps.setString(5, empleado.getCargo());
      ps.setDate(6, Date.valueOf(empleado.getFechaContratacion()));
      ps.setInt(7, empleado.getId());

      ps.executeUpdate();

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al actualizar empleado: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }

  // =========================
  // ELIMINAR
  // =========================
  public void eliminar(int id) {

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(DELETE);
      ps.setInt(1, id);
      ps.executeUpdate();

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al eliminar empleado: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }
}
