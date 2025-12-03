package com.wvl.stage4.dao;

import com.wvl.stage4.database.ConexionDB;
import com.wvl.stage4.models.ReporteVenta;
import com.wvl.stage4.models.Venta;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {

  private static final String INSERT =
  "INSERT INTO ventas (producto_id, empleado_id, cantidad, precio_unitario, fecha_venta) " +
  "VALUES (?, ?, ?, ?, ?)";

  private static final String SELECT_ALL = "SELECT * FROM ventas";

  // ==============================================================
  // INSERTAR
  // ==============================================================
  public void insertar(Venta venta) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

      ps.setInt(1, venta.getProductoId());
      ps.setInt(2, venta.getEmpleadoId());
      ps.setInt(3, venta.getCantidad());
      ps.setDouble(4, venta.getPrecioUnitario());
      ps.setTimestamp(5, Timestamp.valueOf(venta.getFechaVenta()));

      ps.executeUpdate();

      rs = ps.getGeneratedKeys();
      if (rs.next()) venta.setId(rs.getInt(1));

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al insertar venta: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }

  // ==============================================================
  // OBTENER TODAS
  // ==============================================================
  public List<Venta> obtenerTodas() {

    List<Venta> ventas = new ArrayList<>();

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = ConexionDB.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(SELECT_ALL);

      while (rs.next()) {
        ventas.add(new Venta(
        rs.getInt("id"),
        rs.getInt("producto_id"),
        rs.getInt("empleado_id"),
        rs.getInt("cantidad"),
        rs.getDouble("precio_unitario"),
        rs.getTimestamp("fecha_venta").toLocalDateTime()
        ));
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener ventas: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return ventas;
  }

  // ==============================================================
  // REPORTE COMPLETO
  // ==============================================================
  public List<ReporteVenta> obtenerReporteCompleto() {

    List<ReporteVenta> reportes = new ArrayList<>();

    String sql =
    "SELECT v.id, p.nombre AS prod, e.nombre AS emp, e.apellido AS emp_ape, " +
    "v.cantidad, v.precio_unitario, v.fecha_venta " +
    "FROM ventas v " +
    "JOIN productos p ON v.producto_id = p.id " +
    "JOIN empleados e ON v.empleado_id = e.id WHERE p.activo = 1 " +
    "ORDER BY v.fecha_venta DESC";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = ConexionDB.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      while (rs.next()) {

        String nombreEmpleado = rs.getString("emp") + " " + rs.getString("emp_ape");

        ReporteVenta fila = new ReporteVenta(
        rs.getInt("id"),
        rs.getString("prod"),
        nombreEmpleado,
        rs.getInt("cantidad"),
        rs.getDouble("precio_unitario"),
        rs.getTimestamp("fecha_venta").toLocalDateTime()
        );

        reportes.add(fila);
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener reporte de ventas: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return reportes;
  }

  public boolean registrarVenta(int idProducto, int idEmpleado, int cantidad) throws SQLException {
    Connection conn = ConexionDB.getConnection();

    try {
      conn.setAutoCommit(false);

      // 1. obtener precio y stock
      PreparedStatement ps1 = conn.prepareStatement(
      "SELECT precio, cantidad FROM productos WHERE id = ?");
      ps1.setInt(1, idProducto);
      ResultSet rs = ps1.executeQuery();
      if (!rs.next()) return false;

      double precio = rs.getDouble("precio");
      int stockActual = rs.getInt("cantidad");

      if (cantidad > stockActual) {
        throw new SQLException("Stock insuficiente.");
      }

      // 2. insertar venta
      PreparedStatement ps2 = conn.prepareStatement(
      "INSERT INTO ventas (producto_id, empleado_id, cantidad, precio_unitario, fecha_venta) VALUES (?, ?, ?, ?, NOW())"
      );
      ps2.setInt(1, idProducto);
      ps2.setInt(2, idEmpleado);
      ps2.setInt(3, cantidad);
      ps2.setDouble(4, precio);
      ps2.executeUpdate();

      // 3. actualizar stock
      PreparedStatement ps3 = conn.prepareStatement(
      "UPDATE productos SET cantidad = cantidad - ? WHERE id = ?");
      ps3.setInt(1, cantidad);
      ps3.setInt(2, idProducto);
      ps3.executeUpdate();

      conn.commit();
      return true;

    } catch (Exception e) {
      conn.rollback();
      throw e;
    }
  }
}
