package com.wvl.ef.views;

import com.wvl.ef.dao.ClienteDAO;
import com.wvl.ef.models.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.regex.Pattern;

public class ClienteUI extends JFrame {

  private final ClienteDAO dao = new ClienteDAO();
  private JTable tabla;
  private DefaultTableModel modelo;

  private JTextField txtNom, txtApe, txtEmail, txtTel;

  // email regex simple (no perfecto pero práctico para validación UI)
  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

  public ClienteUI() {
    setTitle("Clientes");
    setSize(700, 420);
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    JLabel l1 = new JLabel("Nombres");
    l1.setBounds(20, 20, 100, 25);
    JLabel l2 = new JLabel("Apellidos");
    l2.setBounds(20, 50, 100, 25);
    JLabel l3 = new JLabel("Email");
    l3.setBounds(20, 80, 100, 25);
    JLabel l4 = new JLabel("Telefono");
    l4.setBounds(20, 110, 100, 25);

    txtNom = new JTextField();
    txtNom.setBounds(120, 20, 200, 25);
    txtApe = new JTextField();
    txtApe.setBounds(120, 50, 200, 25);
    txtEmail = new JTextField();
    txtEmail.setBounds(120, 80, 200, 25);
    txtTel = new JTextField();
    txtTel.setBounds(120, 110, 200, 25);

    JButton btnAgregar = new JButton("Agregar");
    btnAgregar.setBounds(350, 20, 120, 25);
    JButton btnEditar = new JButton("Editar");
    btnEditar.setBounds(350, 55, 120, 25);
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.setBounds(350, 90, 120, 25);
    JButton btnRefrescar = new JButton("Refrescar");
    btnRefrescar.setBounds(350, 125, 120, 25);

    modelo = new DefaultTableModel(new String[] { "ID", "Nombres", "Apellidos", "Email", "Telefono" }, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    tabla = new JTable(modelo);
    JScrollPane sp = new JScrollPane(tabla);
    sp.setBounds(20, 170, 640, 200);

    add(l1);
    add(l2);
    add(l3);
    add(l4);
    add(txtNom);
    add(txtApe);
    add(txtEmail);
    add(txtTel);
    add(btnAgregar);
    add(btnEditar);
    add(btnEliminar);
    add(btnRefrescar);
    add(sp);

    cargarTabla();

    // Rellenar campos al hacer click en la tabla
    tabla.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
          txtNom.setText(modelo.getValueAt(fila, 1).toString());
          txtApe.setText(modelo.getValueAt(fila, 2).toString());
          txtEmail.setText(modelo.getValueAt(fila, 3).toString());
          txtTel.setText(modelo.getValueAt(fila, 4) != null ? modelo.getValueAt(fila, 4).toString() : "");
        }
      }
    });

    btnAgregar.addActionListener(e -> {
      String nombres = txtNom.getText().trim();
      String apellidos = txtApe.getText().trim();
      String email = txtEmail.getText().trim();
      String telefono = txtTel.getText().trim();

      String err = validarCampos(nombres, apellidos, email, telefono);
      if (err != null) {
        JOptionPane.showMessageDialog(this, err, "Validación", JOptionPane.WARNING_MESSAGE);
        return;
      }

      Cliente c = new Cliente(0, nombres, apellidos, email, telefono.isEmpty() ? null : telefono);
      Cliente creado = dao.create(c);
      if (creado != null) {
        limpiarCampos();
        cargarTabla();
        JOptionPane.showMessageDialog(this, "Cliente agregado");
      } else {
        JOptionPane.showMessageDialog(this, "Error al agregar cliente", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    btnEditar.addActionListener(e -> {
      int fila = tabla.getSelectedRow();
      if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para editar", "Atención", JOptionPane.WARNING_MESSAGE);
        return;
      }

      int id = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
      String nombres = txtNom.getText().trim();
      String apellidos = txtApe.getText().trim();
      String email = txtEmail.getText().trim();
      String telefono = txtTel.getText().trim();

      String err = validarCampos(nombres, apellidos, email, telefono);
      if (err != null) {
        JOptionPane.showMessageDialog(this, err, "Validación", JOptionPane.WARNING_MESSAGE);
        return;
      }

      Cliente c = new Cliente(id, nombres, apellidos, email, telefono.isEmpty() ? null : telefono);
      boolean ok = dao.update(c);
      if (ok) {
        limpiarCampos();
        cargarTabla();
        JOptionPane.showMessageDialog(this, "Cliente actualizado");
      } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar cliente", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    btnEliminar.addActionListener(e -> {
      int fila = tabla.getSelectedRow();
      if (fila < 0) {
        JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar", "Atención",
            JOptionPane.WARNING_MESSAGE);
        return;
      }
      int id = Integer.parseInt(modelo.getValueAt(fila, 0).toString());
      int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar el cliente seleccionado?",
          "Confirmar", JOptionPane.YES_NO_OPTION);
      if (resp == JOptionPane.YES_OPTION) {
        boolean ok = dao.delete(id);
        if (ok) {
          limpiarCampos();
          cargarTabla();
          JOptionPane.showMessageDialog(this, "Cliente eliminado");
        } else {
          JOptionPane.showMessageDialog(this, "Error al eliminar cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    btnRefrescar.addActionListener(e -> {
      limpiarCampos();
      cargarTabla();
    });
  }

  private String validarCampos(String nombres, String apellidos, String email, String telefono) {
    if (nombres == null || nombres.isEmpty() || nombres.length() < 2)
      return "El campo 'Nombres' es obligatorio (mín 2 caracteres).";
    if (apellidos == null || apellidos.isEmpty() || apellidos.length() < 2)
      return "El campo 'Apellidos' es obligatorio (mín 2 caracteres).";
    if (email == null || email.isEmpty())
      return "El campo 'Email' es obligatorio.";
    if (!EMAIL_PATTERN.matcher(email).matches())
      return "Formato de email inválido.";
    if (telefono != null && !telefono.isEmpty()) {
      // permitir + al inicio opcional y dígitos, pero para simplificar pedimos solo
      // dígitos
      if (!telefono.matches("\\d+"))
        return "Teléfono inválido: solo dígitos permitidos.";
      if (telefono.length() < 7 || telefono.length() > 15)
        return "Teléfono inválido: debe tener entre 7 y 15 dígitos.";
    }
    return null; // ok
  }

  private void limpiarCampos() {
    txtNom.setText("");
    txtApe.setText("");
    txtEmail.setText("");
    txtTel.setText("");
    tabla.clearSelection();
  }

  void cargarTabla() {
    modelo.setRowCount(0);
    List<Cliente> lista = dao.findAll();
    if (lista == null)
      return;
    for (Cliente c : lista) {
      modelo.addRow(new Object[] {
          c.getId(),
          safe(c.getNombres()),
          safe(c.getApellidos()),
          safe(c.getEmail()),
          safe(c.getTelefono())
      });
    }
  }

  private String safe(String s) {
    return s == null ? "" : s;
  }

  // Opcional: punto de entrada rápido para probar la ventana sola
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      ClienteUI ui = new ClienteUI();
      ui.setVisible(true);
    });
  }
}
