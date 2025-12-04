package com.wvl.stage4.views;

import com.wvl.stage4.dao.EmpleadoDAO;
import com.wvl.stage4.dao.ProductoDAO;
import com.wvl.stage4.dao.VentaDAO;
import com.wvl.stage4.models.ReporteVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PanelReporteVentas extends JPanel {

  private JTable tabla;
  private DefaultTableModel modelo;
  private VentaDAO ventaDAO;
  private JLabel lblTotalVentas;

  public PanelReporteVentas() {
    ventaDAO = new VentaDAO();
    setLayout(new BorderLayout());

    String[] columnas = {"ID Venta", "Producto", "Vendedor", "Cant.", "Precio U.", "Total", "Fecha"};
    modelo = new DefaultTableModel(columnas, 0);
    tabla = new JTable(modelo);

    // Formato básico para la tabla
    tabla.getColumnModel().getColumn(0).setPreferredWidth(50); // ID más pequeño
    tabla.getColumnModel().getColumn(1).setPreferredWidth(200); // Producto más ancho

    add(new JScrollPane(tabla), BorderLayout.CENTER);

    JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton btnRefrescar = new JButton("Actualizar Informe");
    lblTotalVentas = new JLabel("Ingresos Totales: S/ 0.00");
    lblTotalVentas.setFont(new Font("Arial", Font.BOLD, 14));

    btnRefrescar.addActionListener(e -> cargarDatos());

    panelInferior.add(btnRefrescar);
    panelInferior.add(Box.createHorizontalStrut(20));
    panelInferior.add(lblTotalVentas);

    JButton btnVender = new JButton("Realizar Venta");
    btnVender.addActionListener(e -> abrirFormularioVenta());

    panelInferior.add(btnVender);
    panelInferior.add(Box.createHorizontalStrut(20));

    add(panelInferior, BorderLayout.SOUTH);

    cargarDatos();
  }

  private void cargarDatos() {
    modelo.setRowCount(0);
    double sumaTotal = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

      List<ReporteVenta> lista = ventaDAO.obtenerReporteCompleto();
      for (ReporteVenta r : lista) {
        modelo.addRow(new Object[]{
          r.getIdVenta(),
          r.getNombreProducto(),
          r.getNombreEmpleado(),
          r.getCantidad(),
          String.format("S/ %.2f", r.getPrecioUnitario()),
          String.format("S/ %.2f", r.getTotal()),
          r.getFecha().format(formatter)
        });
        sumaTotal += r.getTotal();
      }

      lblTotalVentas.setText(String.format("Ingresos Totales: S/ %.2f", sumaTotal));

  }

  private void abrirFormularioVenta() {
    JDialog dialog = new JDialog((Frame) null, "Registrar Venta", true);
    dialog.setSize(400, 350);
    dialog.setLocationRelativeTo(this);
    dialog.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(8, 8, 8, 8);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // CAMPOS
    JComboBox<String> cmbProductos = new JComboBox<>();
    JComboBox<String> cmbVendedores = new JComboBox<>();
    JTextField txtCantidad = new JTextField();

    // CARGAR PRODUCTOS
    try {
      new ProductoDAO().obtenerTodos().forEach(p ->
      cmbProductos.addItem(p.getId() + " - " + p.getNombre())
      );
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(this, "Error al cargar productos.");
    }

    // CARGAR EMPLEADOS
    try {
      new EmpleadoDAO().obtenerTodos().forEach(emp ->
      cmbVendedores.addItem(emp.getId() + " - " + emp.getNombre())
      );
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al cargar empleados.");
    }

    int fila = 0;

    gbc.gridx = 0; gbc.gridy = fila; dialog.add(new JLabel("Producto:"), gbc);
    gbc.gridx = 1; dialog.add(cmbProductos, gbc);

    fila++;
    gbc.gridx = 0; gbc.gridy = fila; dialog.add(new JLabel("Vendedor:"), gbc);
    gbc.gridx = 1; dialog.add(cmbVendedores, gbc);

    fila++;
    gbc.gridx = 0; gbc.gridy = fila; dialog.add(new JLabel("Cantidad:"), gbc);
    gbc.gridx = 1; dialog.add(txtCantidad, gbc);

    // BOTÓN VENDER
    JButton btnGuardar = new JButton("Registrar Venta");

    fila++;
    gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 2;
    dialog.add(btnGuardar, gbc);

    btnGuardar.addActionListener(e -> {

      try {
        int idProducto = Integer.parseInt(cmbProductos.getSelectedItem().toString().split(" - ")[0]);
        int idEmpleado = Integer.parseInt(cmbVendedores.getSelectedItem().toString().split(" - ")[0]);
        String cantidadTxt = txtCantidad.getText().trim();

// ¿Está vacío?
        if (cantidadTxt.isEmpty()) {
          JOptionPane.showMessageDialog(dialog, "Debe ingresar una cantidad.");
          txtCantidad.requestFocus();
          return;
        }

// ¿Es numérico?
        int cantidad;
        try {
          cantidad = Integer.parseInt(cantidadTxt);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(dialog, "La cantidad debe ser un número entero.");
          txtCantidad.requestFocus();
          return;
        }

// ¿Es mayor a 0?
        if (cantidad <= 0) {
          JOptionPane.showMessageDialog(dialog, "La cantidad debe ser mayor a 0.");
          txtCantidad.requestFocus();
          return;
        }

// VALIDAR STOCK disponible
        int stockActual = new ProductoDAO().obtenerPorId(idProducto).getCantidad(); // o como lo estés obteniendo

        if (cantidad > stockActual) {
          JOptionPane.showMessageDialog(dialog,
          "Stock insuficiente. Disponible: " + stockActual);
          txtCantidad.requestFocus();
          return;
        }

// Si llegamos aquí → la cantidad es válida


        // REGISTRAR VENTA
        boolean ok = ventaDAO.registrarVenta(idProducto, idEmpleado, cantidad);

        if (ok) {
          JOptionPane.showMessageDialog(dialog, "Venta registrada exitosamente.");
          dialog.dispose();
          cargarDatos(); // REFRESCAR REPORTE
        } else {
          JOptionPane.showMessageDialog(dialog, "No se pudo registrar la venta.");
        }

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
      }
    });

    dialog.setVisible(true);
  }


}