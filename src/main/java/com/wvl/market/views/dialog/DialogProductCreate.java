package com.wvl.market.views.dialog;

import com.wvl.market.entity.Product;
import com.wvl.market.services.ProductService;
import com.wvl.market.views.button.ButtonSecondary;
import com.wvl.market.views.button.PrimaryButton;
import com.wvl.market.views.theme.UIConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DialogProductCreate extends javax.swing.JDialog {
  private JButton btnCancel;

  private JTextField nameField;
  private JTextField priceField;
  private JTextField stockField;

  public DialogProductCreate(JFrame parent) {
    super(parent, "Agregar Producto", true);

    setSize(350, 252);
    setLocationRelativeTo(parent);
    setLayout(new GridLayout(5, 2, 12, 12));

    // Campos
    add(new JLabel("Nombre:"));
    nameField = new JTextField();
    nameField.setFont(UIConstants.FONT_SERIF);
    add(nameField);

    add(new JLabel("Precio:"));
    priceField = new JTextField();
    add(priceField);

    add(new JLabel("Stock:"));
    stockField = new JTextField();
    add(stockField);

    // Botones
    JButton btnGuardar = new PrimaryButton("Guardar");
    btnCancel = new ButtonSecondary("Cancelar");

    add(new JLabel("Usuario:"));
    String[] opciones = {"Seleccione una opción", "Activo", "Inactivo", "Pendiente"};
    JComboBox<String> combo = new JComboBox<>(opciones);

    // 🔹 Estilo básico
    combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    combo.setPreferredSize(new Dimension(200, 36));

    // 🔹 Detectar selección
    combo.addActionListener(e -> {
      String seleccion = (String) combo.getSelectedItem();
      System.out.println("Seleccionaste: " + seleccion);
    });

    add(combo);
    add(btnCancel);
    add(btnGuardar);


    // Eventos
    btnGuardar.addActionListener(e -> {
      ProductService productService = new ProductService();

      if(getProduct() != null) {
        productService.createProduct(getProduct());
        dispose(); // cierra el diálog
      }
    });

    getRootPane().setBorder(new EmptyBorder(12,12,12,12));
    btnCancel.addActionListener(e -> dispose());
  }

  public void close() {
    dispose();
  }
  public void open() {
    setSize(350, 204);
    setVisible(true);
  }
  public Product getProduct() {
    Product product = new Product();
    if(nameField.getText().length() < 6) {
      nameField.setForeground(Color.RED);
      nameField.setBackground(Color.decode("#ffe2e2"));
      JOptionPane.showMessageDialog(null, "El nombre debe ser mayor o igual a 6");
      return null;
    }
    nameField.setForeground(Color.decode("#00c950"));
    nameField.setBackground(Color.decode("#dcfce7"));
    product.setName(nameField.getText());
    product.setPrice(Double.parseDouble(priceField.getText()));
    product.setStock(Integer.parseInt(stockField.getText()));
    return product;
  }
}
