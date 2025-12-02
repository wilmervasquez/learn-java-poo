package com.wvl.stage4.view;

import com.wvl.stage4.dao.ProductDAO;
import com.wvl.stage4.models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Deque;

public class AppView {
  private ProductDAO productDAO;
  private DefaultTableModel tableModel;
  private JTable table;
  private JTextField textSku, textName, textPrice, textBrand;
  public AppView() {
    productDAO = new ProductDAO();
  }
  public void createUI() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Products");
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    JPanel panelForm = new JPanel(new GridLayout(4, 2, 12, 12));
    panelForm.setBorder(BorderFactory.createTitledBorder("Detalles del producto"));

    panelForm.add(new JLabel("SKU"));
    panelForm.add(textSku = new JTextField(""));
    panelForm.add(new JLabel("Nombre"));
    panelForm.add(textName = new JTextField(""));
    panelForm.add(new JLabel("Precio"));
    panelForm.add(textPrice = new JTextField(""));
    panelForm.add(new JLabel("Marca"));
    panelForm.add(textBrand = new JTextField(""));


    JPanel panelButtons = new JPanel(new GridLayout(1, 2, 12, 12));

    JButton btnAdd = new JButton("Agregar");
    JButton btnFind = new JButton("Buscar");
    JButton btnUpdate = new JButton("Actualizar");
    JButton btnDelete = new JButton("Eliminar");

    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        productDAO.addProduct(getProductForm());
      }
    });

    btnFind.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    btnDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });

    panelButtons.add(btnAdd);
    panelButtons.add(btnFind);
    panelButtons.add(btnUpdate);
    panelButtons.add(btnDelete);

    tableModel = new DefaultTableModel(new String[]{"SKU", "Nombre", "Precio", "Marca"},0 );
    table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);

    frame.add(panelForm, BorderLayout.NORTH);
    frame.add(panelButtons, BorderLayout.SOUTH);
    frame.add(scrollPane, BorderLayout.CENTER);

    frame.setVisible(true);
  }

  public Product getProductForm() {

    String sku = textSku.getText();

    String name = textName.getText();

    String price = textPrice.getText();
    String brand = textBrand.getText();

    Product product = new Product();
    product.setSku(sku);
    product.setName(name);
    product.setPrice(Double.parseDouble(price));
    product.setBrand(brand);
    return product;
  }
}
