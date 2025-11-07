package com.wvl.negocio.vista;

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

  private JButton btnGuardar;
  private JButton btnLimpiar;

  private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public PanelAgregarProducto () {
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

    // Añadir al panel
    int row = 0;
    addField(formPanel, gbc, row++, "Código:", txtCodigo);
    addField(formPanel, gbc, row++, "Nombre:", txtNombre);
    addField(formPanel, gbc, row++, "Precio Unitario:", txtPrecioUnitario);
    addField(formPanel, gbc, row++, "Descripción:", new JScrollPane(txtDescripcion));
    addField(formPanel, gbc, row++, "Imagen (URL o ruta):", txtImagen);
    addField(formPanel, gbc, row++, "Stock:", spnStock);
    addField(formPanel, gbc, row++, "Fecha de Vencimiento:", txtFechaVencimiento);

    // Botones
    JPanel buttonPanel = new JPanel();
    btnGuardar = new JButton("Guardar");
    btnLimpiar = new JButton("Limpiar");
    buttonPanel.add(btnGuardar);
    buttonPanel.add(btnLimpiar);

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

  // Obtener un objeto Producto a partir de los datos del formulario
  public Producto getProducto() {
    try {
      String codigo = txtCodigo.getText();
      String nombre = txtNombre.getText();
      Double precio = Double.parseDouble(txtPrecioUnitario.getText());
      String descripcion = txtDescripcion.getText();
      String imagen = txtImagen.getText();
      int stock = (Integer) spnStock.getValue();
      LocalDate fecha = LocalDate.parse(txtFechaVencimiento.getText(), dateFormatter);

      return new Producto(codigo, nombre, precio, descripcion, imagen, stock, fecha);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al leer los datos: " + e.getMessage(),
      "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
  }

  // Cargar los datos de un Producto existente al formulario
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
  }

  // Limpia los campos del formulario
  public void limpiar() {
    txtCodigo.setText("");
    txtNombre.setText("");
    txtPrecioUnitario.setText("");
    txtDescripcion.setText("");
    txtImagen.setText("");
    spnStock.setValue(0);
    txtFechaVencimiento.setText("");
  }

  // Métodos para acceder a los botones (para controladores externos)
  public JButton getBtnGuardar() {
    return btnGuardar;
  }

  public JButton getBtnLimpiar() {
    return btnLimpiar;
  }
}
