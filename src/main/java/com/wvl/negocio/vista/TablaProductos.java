package com.wvl.negocio.vista;

import javax.swing.*;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class TablaProductos extends JPanel {
  private JTable tabla;
  private DefaultTableModel modelo;
  private JButton btnActualizar;
  private JButton btnEditar;
  private JButton btnEliminar;

  private List<Producto> productos = new ArrayList<>();
  private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public TablaProductos(ProductoControlador productoControlador) {
    setLayout(new BorderLayout(10, 10));
    setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
    setBackground(Color.WHITE);

    // Modelo de tabla
    modelo = new DefaultTableModel(new Object[]{
    "Código", "Nombre", "Precio Unitario", "Stock", "Fecha Vencimiento"
    }, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false; // No permitir edición directa
      }
    };

    tabla = new JTable(modelo);
    tabla.setFillsViewportHeight(true);
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane scrollPane = new JScrollPane(tabla);
    add(scrollPane, BorderLayout.CENTER);

    // Panel de botones
    JPanel buttonPanel = new JPanel();
    btnActualizar = new JButton("Actualizar");
    btnEditar = new JButton("Editar");
    btnEliminar = new JButton("Eliminar");

    buttonPanel.add(btnActualizar);
    buttonPanel.add(btnEditar);
    buttonPanel.add(btnEliminar);

    add(buttonPanel, BorderLayout.SOUTH);

    // Acción: actualizar lista desde el controlador
    btnActualizar.addActionListener(e -> setProductos(productoControlador.getProductos()));

    // Acción: editar producto
    btnEditar.addActionListener(e -> {
      int fila = tabla.getSelectedRow();
      if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
      }
      Producto productoSeleccionado = productos.get(fila);
      mostrarModalEdicion(productoSeleccionado, fila);
    });

    // Acción: eliminar producto
    btnEliminar.addActionListener(e -> {
      int fila = tabla.getSelectedRow();
      if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
      }

      int confirm = JOptionPane.showConfirmDialog(this,
      "¿Estás seguro de que deseas eliminar este producto?",
      "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

      if (confirm == JOptionPane.YES_OPTION) {
        eliminarSeleccionado();
      }
    });
  }

  // Modal de edición
  private void mostrarModalEdicion(Producto producto, int fila) {
    JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Editar Producto", true);
    dialog.setLayout(new GridLayout(6, 2, 10, 10));
    dialog.setSize(400, 300);
    dialog.setLocationRelativeTo(this);

    JTextField txtCodigo = new JTextField(String.valueOf(producto.getCodigo()));
    JTextField txtNombre = new JTextField(producto.getNombre());
    JTextField txtPrecio = new JTextField(String.valueOf(producto.getPrecioUnitario()));
    JTextField txtStock = new JTextField(String.valueOf(producto.getStock()));
    JTextField txtFecha = new JTextField(producto.getFechaVencimiento() != null ?
    producto.getFechaVencimiento().format(dateFormatter) : "");

    dialog.add(new JLabel("Código:"));
    dialog.add(txtCodigo);
    dialog.add(new JLabel("Nombre:"));
    dialog.add(txtNombre);
    dialog.add(new JLabel("Precio Unitario:"));
    dialog.add(txtPrecio);
    dialog.add(new JLabel("Stock:"));
    dialog.add(txtStock);
    dialog.add(new JLabel("Fecha Vencimiento (yyyy-MM-dd):"));
    dialog.add(txtFecha);

    JButton btnGuardar = new JButton("Guardar");
    JButton btnCancelar = new JButton("Cancelar");

    dialog.add(btnGuardar);
    dialog.add(btnCancelar);

    btnCancelar.addActionListener(e -> dialog.dispose());

    btnGuardar.addActionListener(e -> {
      try {
        // Actualiza valores del producto
        producto.setCodigo(txtCodigo.getText().trim());
        producto.setNombre(txtNombre.getText().trim());
        producto.setPrecioUnitario(Double.parseDouble(txtPrecio.getText().trim()));
        producto.setStock(Integer.parseInt(txtStock.getText().trim()));
        if (!txtFecha.getText().trim().isEmpty()) {
          producto.setFechaVencimiento(LocalDate.parse(txtFecha.getText().trim(), dateFormatter));
        } else {
          producto.setFechaVencimiento(null);
        }

        actualizarProducto(fila, producto);
        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dialog.dispose();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    dialog.setVisible(true);
  }

  // Eliminar producto
  public void eliminarSeleccionado() {
    int fila = tabla.getSelectedRow();
    if (fila != -1) {
      productos.remove(fila);
      modelo.removeRow(fila);
    }
  }

  // Actualizar producto en tabla
  public void actualizarProducto(int fila, Producto producto) {
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

  // Refrescar tabla completa
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
