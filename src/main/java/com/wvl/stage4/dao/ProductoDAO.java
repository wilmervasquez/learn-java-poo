package com.wvl.stage4.dao;

import com.wvl.stage4.database.ConexionDB;
import com.wvl.stage4.models.Categoria;
import com.wvl.stage4.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

  private static final String INSERT = "INSERT INTO productos (sku, nombre, marca, precio, cantidad, categoria_id) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String SELECT_ALL = "SELECT * FROM productos p JOIN categorias c ON p.categoria_id = c.id WHERE activo = 1";
  private static final String SELECT_BY_ID = "SELECT * FROM productos p JOIN categorias c ON p.categoria_id = c.id WHERE activo = 1 && p.id = ?";
  private static final String UPDATE = "UPDATE productos SET sku = ?, nombre = ?, marca = ?, precio = ?, cantidad = ?, categoria_id = ? WHERE id = ?";
  private static final String DELETE = "UPDATE productos SET activo = 0 WHERE id = ?";

  public void insertar(Producto producto) throws SQLException {
    try {
      Connection conn = ConexionDB.getConnection();
      PreparedStatement ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, producto.getSku());
      ps.setString(2, producto.getNombre());
      ps.setString(3, producto.getMarca());
      ps.setDouble(4, producto.getPrecio());
      ps.setInt(5, producto.getCantidad());
      ps.setInt(6, producto.getCategoriaId());
      ps.executeUpdate();

      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        producto.setId(rs.getInt(1));
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public Producto obtenerPorId(int id) throws SQLException {
    Producto producto = null;

    try {
      Connection conn = ConexionDB.getConnection();
      PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        producto = new Producto(
          rs.getInt("p.id"),
          rs.getString("sku"),
          rs.getString("nombre"),
          rs.getString("marca"),
          rs.getDouble("precio"),
          rs.getInt("cantidad"),
          rs.getInt("categoria_id")
        );
      }

      return producto;
    } catch (SQLException e) {
      System.out.println(e);
    }
    return null;
  }

  public List<Producto> obtenerTodos() {
    List<Producto> productos = new ArrayList<>();
    try {
      Connection conn = ConexionDB.getConnection();

       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(SELECT_ALL);

      while (rs.next()) {
        Producto producto = new Producto(
          rs.getInt("id"),
          rs.getString("sku"),
          rs.getString("nombre"),
          rs.getString("marca"),
          rs.getDouble("precio"),
          rs.getInt("cantidad"),
          rs.getInt("categoria_id")
        );
        producto.setCategoria(new Categoria(rs.getInt("categoria_id"), rs.getString("c.nombre")));
        productos.add(producto);
      }
    }  catch (SQLException e) {
      System.out.println(e);
    }
    return productos;
  }

  public void actualizar(Producto producto) throws SQLException {
    try {
      Connection conn = ConexionDB.getConnection();
      PreparedStatement ps = conn.prepareStatement(UPDATE);

      ps.setString(1, producto.getSku());
      ps.setString(2, producto.getNombre());
      ps.setString(3, producto.getMarca());
      ps.setDouble(4, producto.getPrecio());
      ps.setInt(5, producto.getCantidad());
      ps.setInt(6, producto.getCategoriaId());
      ps.setInt(7, producto.getId());
      ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public void eliminar(int id) throws SQLException {
    try {
      Connection conn = ConexionDB.getConnection();

         PreparedStatement ps = conn.prepareStatement(DELETE);
      ps.setInt(1, id);
      ps.executeUpdate();
    }  catch (SQLException e) {
      System.out.println(e);
    }
  }
}