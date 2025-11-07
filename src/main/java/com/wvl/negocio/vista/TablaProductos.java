package com.wvl.negocio.vista;

import javax.swing.*;

import com.wvl.negocio.entidades.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
public class TablaProductos extends JPanel {
  private JTable tabla;
  private DefaultTableModel modelo;
  private JButton btnAgregar;
  private JButton btnEditar;
  private JButton btnEliminar;

  private List<Producto> productos = new ArrayList<>();
  private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public TablaProductos() {
    setLayout(new BorderLayout(10, 10));
    setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
    setBackground(Color.WHITE);

    // Modelo de tabla
    modelo = new DefaultTableModel(new Object[]{
    "Código", "Nombre", "Precio Unitario", "Stock", "Fecha Vencimiento"
    }, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false; // No permitir edición directa en la tabla
      }
    };

    tabla = new JTable(modelo);
    tabla.setFillsViewportHeight(true);
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane scrollPane = new JScrollPane(tabla);
    add(scrollPane, BorderLayout.CENTER);

    // Panel inferior con botones
    JPanel buttonPanel = new JPanel();
    btnAgregar = new JButton("Agregar");
    btnEditar = new JButton("Editar");
    btnEliminar = new JButton("Eliminar");

    buttonPanel.add(btnAgregar);
    buttonPanel.add(btnEditar);
    buttonPanel.add(btnEliminar);

    add(buttonPanel, BorderLayout.SOUTH);
  }

  // Método para agregar un producto a la lista y tabla
  public void agregarProducto(Producto producto) {
    if (producto == null) return;
    productos.add(producto);
    modelo.addRow(new Object[]{
    producto.getCodigo(),
    producto.getNombre(),
    producto.getPrecioUnitario(),
    producto.getStock(),
    producto.getFechaVencimiento() != null ? producto.getFechaVencimiento().format(dateFormatter) : ""
    });
  }

  // Método para obtener el producto seleccionado
  public Producto getProductoSeleccionado() {
    int fila = tabla.getSelectedRow();
    if (fila == -1) return null;
    return productos.get(fila);
  }

  // Método para eliminar el producto seleccionado
  public void eliminarSeleccionado() {
    int fila = tabla.getSelectedRow();
    if (fila != -1) {
      productos.remove(fila);
      modelo.removeRow(fila);
    } else {
      JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
  }

  // Método para actualizar un producto (por ejemplo, tras editar)
  public void actualizarProducto(int fila, Producto producto) {
    if (fila < 0 || fila >= productos.size() || producto == null) return;
    productos.set(fila, producto);
    modelo.setValueAt(producto.getCodigo(), fila, 0);
    modelo.setValueAt(producto.getNombre(), fila, 1);
    modelo.setValueAt(producto.getPrecioUnitario(), fila, 2);
    modelo.setValueAt(producto.getStock(), fila, 3);
    modelo.setValueAt(
    producto.getFechaVencimiento() != null ? producto.getFechaVencimiento().format(dateFormatter) : "",
    fila, 4
    );
  }

  public JButton getBtnAgregar() {
    return btnAgregar;
  }

  public JButton getBtnEditar() {
    return btnEditar;
  }

  public JButton getBtnEliminar() {
    return btnEliminar;
  }

  public JTable getTabla() {
    return tabla;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = new ArrayList<>(productos);
    modelo.setRowCount(0);

    for (Producto p : this.productos) {
      modelo.addRow(new Object[]{
      p.getCodigo(),
      p.getNombre(),
      p.getPrecioUnitario(),
      p.getStock(),
      p.getFechaVencimiento() != null ? p.getFechaVencimiento().format(dateFormatter) : ""
      });
    }
  }
}
