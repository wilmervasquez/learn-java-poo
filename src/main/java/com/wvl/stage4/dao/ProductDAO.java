package com.wvl.stage4.dao;

import com.wvl.stage4.database.ConnectionDB;
import com.wvl.stage4.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
  public boolean addProduct(Product product) {
    try {
      Connection connection = ConnectionDB.getConnection();
      PreparedStatement stm = connection.prepareStatement("INSERT INTO products (sku, nombre, marca, precio, categoria_id) VALUES (?,?,?,?,?)");

      stm.setString(1, "");
      stm.setString(2, product.getName());
      stm.setString(3, product.getBrand());
      stm.setDouble(4, product.getPrice());
      stm.setInt(5, product.getCategory().getId());

      stm.executeUpdate();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    try {
      Connection connection = ConnectionDB.getConnection();

      Statement stm = connection.createStatement();
      ResultSet rs = stm.executeQuery("SELECT * FROM products");
      while (rs.next()) {
        products.add(new Product(
          rs.getInt("id"),
          rs.getString("sku"),
          rs.getString("nombre"),
          rs.getDouble("precio"),
          rs.getString("marca")
        ));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return products;
  }
  public Product getProductById(int id) {

    try {
      Connection connection = ConnectionDB.getConnection();

      PreparedStatement smt = connection.prepareStatement("SELECT * FROM products WHERE id = ?");
      smt.setInt(1, id);
      ResultSet rs = smt.executeQuery();

      while (rs.next()) {
        return new Product(
          rs.getInt("id"),
          rs.getString("sku"),
          rs.getString("nombre"),
          rs.getDouble("precio"),
          rs.getString("marca")
        );
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  public boolean updateProduct(int id, Product product) {
    try {
      Connection connection = ConnectionDB.getConnection();
      PreparedStatement presmt = connection.prepareStatement("UPDATE products SET sku = ?, nombre = ?, marca = ?, precio = ? WHERE id = ?");

      presmt.setString(1, product.getSku());
      presmt.setString(2, product.getName());
      presmt.setString(3, product.getBrand());
      presmt.setDouble(4, product.getPrice());

      presmt.setInt(5, id);

      int rowsUpdates = presmt.executeUpdate();
      if (rowsUpdates > 0) return true;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  public boolean deleteProduct(int id) {
    try {
      Connection connection = ConnectionDB.getConnection();

      PreparedStatement presmt = connection.prepareStatement("DELETE FROM products WHERE id = ?");

      presmt.setInt(1, id);
      presmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return false;
  }
}
