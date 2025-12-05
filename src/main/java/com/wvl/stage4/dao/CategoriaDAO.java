package com.wvl.stage4.dao;

import com.wvl.stage4.database.ConexionDB;
import com.wvl.stage4.models.Categoria;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

  private static final String INSERT = "INSERT INTO categorias (nombre) VALUES (?)";
  private static final String SELECT_ALL = "SELECT * FROM categorias";
  private static final String SELECT_BY_ID = "SELECT * FROM categorias WHERE id = ?";
  private static final String UPDATE = "UPDATE categorias SET nombre = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM categorias WHERE id = ?";

  public void insertar(Categoria categoria) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

      ps.setString(1, categoria.getNombre());
      ps.executeUpdate();

      rs = ps.getGeneratedKeys();
      if (rs.next()) categoria.setId(rs.getInt(1));

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al insertar categoría: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }

  public Categoria obtenerPorId(int id) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Categoria categoria = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(SELECT_BY_ID);
      ps.setInt(1, id);

      rs = ps.executeQuery();

      if (rs.next()) {
        categoria = new Categoria(
          rs.getInt("id"),
          rs.getString("nombre")
        );
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener categoría: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return categoria;
  }

  public List<Categoria> obtenerTodos() {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Categoria> categorias = new ArrayList<>();

    try {
      conn = ConexionDB.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(SELECT_ALL);

      while (rs.next()) {
        categorias.add(new Categoria(
        rs.getInt("id"),
        rs.getString("nombre")
        ));
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al obtener categorías: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }

    return categorias;
  }

  public void actualizar(Categoria categoria) {

    Connection conn = null;
    PreparedStatement ps = null;

    try {
      conn = ConexionDB.getConnection();
      ps = conn.prepareStatement(UPDATE);

      ps.setString(1, categoria.getNombre());
      ps.setInt(2, categoria.getId());
      ps.executeUpdate();

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,
      "Error al actualizar categoría: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }

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
      "Error al eliminar categoría: " + e.getMessage(),
      "Error SQL",
      JOptionPane.ERROR_MESSAGE
      );
    }
  }
}
