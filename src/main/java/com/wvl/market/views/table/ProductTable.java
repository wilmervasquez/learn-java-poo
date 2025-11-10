package com.wvl.market.views.table;

import com.wvl.market.entity.Product;
import com.wvl.market.services.ProductService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ProductTable {
  public JScrollPane scrollPane;
  public JTable table;
  private ProductTableModel productTableModel;

  public ProductTable() {
    productTableModel = new ProductTableModel();

    reloadProducts();

    table = new JTable(productTableModel);
    table.setFillsViewportHeight(true);
    table.setRowHeight(32);
    table.setGridColor(Color.LIGHT_GRAY);
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(false);
    table.setBackground(null); // fondo gris claro
    table.setForeground(Color.DARK_GRAY);          // texto oscuro
    table.setSelectionBackground(Color.decode("#96f7e4")); // selección azul
    table.setSelectionForeground(Color.decode("#00786f"));
    table.setFont(new Font("Geist", Font.PLAIN, 14));
    table.getTableHeader().setFont(new Font("Geist", Font.BOLD, 14));
    table.getTableHeader().setBackground(Color.decode("#00bba7"));
    table.getTableHeader().setForeground(Color.WHITE);
    scrollPane = new JScrollPane(table);
    scrollPane.setBorder(new EmptyBorder(12,12,12,12));
  }

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setProducts(ArrayList<Product> products) {
    productTableModel.setProducts(products);
  }

  public void reloadProducts() {
    ProductService productService = new ProductService();
    ArrayList<Product> productos = productService.getAll();
    setProducts(productos);
  }
}
