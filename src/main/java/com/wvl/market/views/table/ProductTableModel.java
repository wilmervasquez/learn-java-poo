package com.wvl.market.views.table;

import com.wvl.market.entity.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
  private final ArrayList<Product> products;
  private final String[] columnNames = {"Id", "Producto", "Precio", "Stock","Actualizado", "Creado"};

  public ProductTableModel() {
    this.products = new ArrayList<>();
  }

  @Override
  public int getRowCount() {
    return products.size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Product p = products.get(rowIndex);
    return switch (columnIndex) {
      case 0 -> "   " + p.getId();
      case 1 -> p.getName();
      case 2 -> "S/ " + p.getPrice();
      case 3 -> p.getStock() + " uds";
      case 4 -> p.getUpdatedAt();
      case 5 -> p.getCreatedAt();
      default -> null;
    };
  }

  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  public void setProducts(ArrayList<Product> products) {
    this.products.clear();
    this.products.addAll(products);

    fireTableDataChanged();
  }
}
