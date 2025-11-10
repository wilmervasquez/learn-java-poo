package com.wvl.market.services;

import com.wvl.market.database.MySQL;
import com.wvl.market.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductService {
  MySQL mysql;
  public ProductService() {
    this.mysql = MySQL.getInstance();
  }

  public Product getProduct(int id) {
    return new Product();
  }

  public void updateProduct(Product product) {

  }
  public void deleteProduct(int id) {
  }
  public boolean createProduct(Product product) {
    try (PreparedStatement stmt = mysql.getConnection().prepareStatement("INSERT INTO products (name, price, stock) VALUES (?, ?, ?)")) {
      stmt.setString(1, product.getName());
      stmt.setDouble(2, product.getPrice());
      stmt.setInt(3, product.getStock());
      int filas = stmt.executeUpdate();
      System.out.println(filas);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  public ArrayList<Product> getAll() {
    String sql = "SELECT * FROM products ORDER BY updated_at DESC";

    ArrayList<Product> products = new ArrayList<Product>();
    try {
      Statement stmt = mysql.getConnection().createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        product.setStock(rs.getInt("stock"));
        product.setUpdatedAt(rs.getDate("updated_at"));
        product.setCreatedAt(rs.getDate("created_at"));
        products.add(product);
      }

      rs.close();
      stmt.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return products;
  }
}
