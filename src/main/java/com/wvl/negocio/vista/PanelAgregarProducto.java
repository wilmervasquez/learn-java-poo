package com.wvl.negocio.vista;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PanelAgregarProducto extends JPanel {
  private JTextField txtCodigo;
  private JTextField txtNombre;
  private JTextField txtPrecioUnitario;
  private JTextArea txtDescripcion;
  private JTextField txtImagen;
  private JSpinner spnStock;
  private JTextField txtFechaVencimiento;
  private JComboBox<String> cmbCategoria; // 🔹 Nuevo campo

  private JButton btnGuardar;
  private JButton btnLimpiar;

  private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public PanelAgregarProducto(ProductoControlador controlador) {
    setLayout(new BorderLayout(10, 10));
    setBorder(BorderFactory.createTitledBorder("Formulario de Producto"));
    setBackground(Color.WHITE);

    JPanel formPanel = new JPanel(new GridBagLayout());
    formPanel.setBackground(Color.WHITE);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;

    // Campos
    txtCodigo = new JTextField(15);
    txtNombre = new JTextField(15);
    txtPrecioUnitario = new JTextField(15);
    txtDescripcion = new JTextArea(3, 15);
    txtDescripcion.setLineWrap(true);
    txtDescripcion.setWrapStyleWord(true);
    txtImagen = new JTextField(15);
    spnStock = new JSpinner(new SpinnerNumberModel(0, 0, 999999, 1));
    txtFechaVencimiento = new JTextField(15);
    txtFechaVencimiento.setToolTipText("Formato: yyyy-MM-dd");

    // 🔹 ComboBox de categoría
    cmbCategoria = new JComboBox<>(new String[]{
    "Electrónicos",
    "Computadoras",
    "Accesorios",
    "Audio",
    "Impresoras",
    "Almacenamiento",
    "Cámaras",
    "Otros"
    });

    // Añadir campos al formulario
    int row = 0;
    addField(formPanel, gbc, row++, "Código:", txtCodigo);
    addField(formPanel, gbc, row++, "Nombre:", txtNombre);
    addField(formPanel, gbc, row++, "Precio Unitario:", txtPrecioUnitario);
    addField(formPanel, gbc, row++, "Descripción:", new JScrollPane(txtDescripcion));
    addField(formPanel, gbc, row++, "Imagen (URL o ruta):", txtImagen);
    addField(formPanel, gbc, row++, "Stock:", spnStock);
    addField(formPanel, gbc, row++, "Fecha de Vencimiento:", txtFechaVencimiento);
    addField(formPanel, gbc, row++, "Categoría:", cmbCategoria); // 🔹 Nuevo campo visual

    // Botones
    JPanel buttonPanel = new JPanel();
    btnGuardar = new JButton("Guardar");
    btnLimpiar = new JButton("Limpiar");
    buttonPanel.add(btnGuardar);
    buttonPanel.add(btnLimpiar);

    // Acción de guardar
    btnGuardar.addActionListener(e -> {
      Producto nuevo = getProducto();
      if (nuevo != null && controlador.agregarProducto(nuevo)) {
        JOptionPane.showMessageDialog(this, "Producto agregado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiar();
      } else {
        JOptionPane.showMessageDialog(this, "No se pudo agregar el producto (verifique código o datos)", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    // Acción de limpiar
    btnLimpiar.addActionListener(e -> limpiar());

    add(formPanel, BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
  }

  private void addField(JPanel panel, GridBagConstraints gbc, int row, String labelText, Component field) {
    gbc.gridx = 0;
    gbc.gridy = row;
    panel.add(new JLabel(labelText), gbc);

    gbc.gridx = 1;
    panel.add(field, gbc);
  }

  // 🔹 Crear un Producto desde los campos del formulario
  public Producto getProducto() {
    try {
      String codigo = txtCodigo.getText().trim();
      String nombre = txtNombre.getText().trim();
      Double precio = Double.parseDouble(txtPrecioUnitario.getText().trim());
      String descripcion = txtDescripcion.getText().trim();
      String imagen = txtImagen.getText().trim();
      int stock = (Integer) spnStock.getValue();
      LocalDate fecha = LocalDate.parse(txtFechaVencimiento.getText().trim(), dateFormatter);
      String categoria = (String) cmbCategoria.getSelectedItem(); // 🔹 Nueva línea

      return new Producto(codigo, nombre, precio, descripcion, imagen, stock, fecha, categoria);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al leer los datos: " + e.getMessage(),
      "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  // 🔹 Cargar datos de un producto existente
  public void setProducto(Producto producto) {
    if (producto == null) return;
    txtCodigo.setText(producto.getCodigo());
    txtNombre.setText(producto.getNombre());
    txtPrecioUnitario.setText(String.valueOf(producto.getPrecioUnitario()));
    txtDescripcion.setText(producto.getDescripcion());
    txtImagen.setText(producto.getImagen());
    spnStock.setValue(producto.getStock());
    if (producto.getFechaVencimiento() != null)
      txtFechaVencimiento.setText(producto.getFechaVencimiento().format(dateFormatter));
    cmbCategoria.setSelectedItem(producto.getCategoria()); // 🔹 Nueva línea
  }

  // 🔹 Limpiar campos
  public void limpiar() {
    txtCodigo.setText("");
    txtNombre.setText("");
    txtPrecioUnitario.setText("");
    txtDescripcion.setText("");
    txtImagen.setText("");
    spnStock.setValue(0);
    txtFechaVencimiento.setText("");
    cmbCategoria.setSelectedIndex(0); // 🔹 Restablecer selección
  }

  public JButton getBtnGuardar() {
    return btnGuardar;
  }

  public JButton getBtnLimpiar() {
    return btnLimpiar;
  }
}
