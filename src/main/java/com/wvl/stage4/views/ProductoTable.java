package com.wvl.stage4.views;

import com.wvl.market.entity.Product;
import com.wvl.stage4.dao.ProductoDAO;
import com.wvl.stage4.models.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoTable extends JScrollPane {
  private JTable tablaProductos;
  private DefaultTableModel tableModel;
  public ProductoTable() {
    String[] columnNames = {"ID", "SKU", "Nombre", "Marca", "Precio", "Cantidad", "Categoría"};
    tableModel = new DefaultTableModel(columnNames, 0);
    tablaProductos = new JTable(tableModel);
    add(tablaProductos);
  }
  void setProductos(List<Producto> productos) {
    tableModel.setRowCount(0);

    for (Producto p : productos) {
      tableModel.addRow(new Object[]{
      p.getId(),
      p.getSku(),
      p.getNombre(),
      p.getMarca(),
      p.getPrecio(),
      p.getCantidad(),
      p.getCategoria().getNombre()
      });
    }
  }

  void refresh() {
    List<Producto> productos = new ProductoDAO().obtenerTodos();
    setProductos(productos);
  }
}
