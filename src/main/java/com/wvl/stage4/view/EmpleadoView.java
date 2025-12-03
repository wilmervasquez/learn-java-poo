package com.wvl.stage4.view;

import com.wvl.stage4.dao.EmpleadoDAO;
import com.wvl.stage4.models.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class EmpleadoView extends JPanel {

  private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

  private JTextField txtId, txtNombre, txtApellido, txtDni, txtTelefono, txtCargo, txtFecha;
  private JTable tabla;
  private DefaultTableModel modelo;

  public EmpleadoView() {
    setLayout(new BorderLayout(10, 10));
    iniciarComponentes();
    listarEmpleados();
  }

  private void iniciarComponentes() {

    // ============================
    // PANEL SUPERIOR (FORMULARIO)
    // ============================

    JPanel panelForm = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    panelForm.setBorder(BorderFactory.createTitledBorder("Datos del Empleado"));
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    txtId = new JTextField();
    txtId.setEnabled(false);
    txtNombre = new JTextField();
    txtApellido = new JTextField();
    txtDni = new JTextField();
    txtTelefono = new JTextField();
    txtCargo = new JTextField();
    txtFecha = new JTextField();

    int fila = 0;

    agregarCampo(panelForm, gbc, fila++, "ID:", txtId);
    agregarCampo(panelForm, gbc, fila++, "Nombre:", txtNombre);
    agregarCampo(panelForm, gbc, fila++, "Apellido:", txtApellido);
    agregarCampo(panelForm, gbc, fila++, "DNI:", txtDni);
    agregarCampo(panelForm, gbc, fila++, "Teléfono:", txtTelefono);
    agregarCampo(panelForm, gbc, fila++, "Cargo:", txtCargo);
    agregarCampo(panelForm, gbc, fila++, "Fecha Contratación (YYYY-MM-DD):", txtFecha);

    add(panelForm, BorderLayout.NORTH);


    // ============================
    // PANEL CENTRAL (BOTONES)
    // ============================

    JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
    panelBotones.setBorder(BorderFactory.createTitledBorder("Acciones"));

    JButton btnAgregar = Base.createButtonBrand("Agregar");
    JButton btnActualizar = Base.createButtonBrand("Actualizar");
    JButton btnEliminar = Base.createButtonDestructive("Despedir");
    JButton btnLimpiar = Base.createButtonBrand("Limpiar");
    JButton btnListar = Base.createButtonBrand("Listar");

    panelBotones.add(btnAgregar);
    panelBotones.add(btnActualizar);
    panelBotones.add(btnEliminar);
    panelBotones.add(btnLimpiar);
    panelBotones.add(btnListar);

    add(panelBotones, BorderLayout.CENTER);


    // ============================
    // PANEL INFERIOR (TABLA)
    // ============================

    modelo = new DefaultTableModel(
    new String[]{"ID", "Nombre", "Apellido", "DNI", "Teléfono", "Cargo", "Fecha"},
    0
    );

    tabla = new JTable(modelo);
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JScrollPane scroll = new JScrollPane(tabla);
    scroll.setBorder(BorderFactory.createTitledBorder("Lista de Empleados"));

    add(scroll, BorderLayout.SOUTH);

    // Eventos
    btnAgregar.addActionListener(e -> agregarEmpleado());
    btnActualizar.addActionListener(e -> actualizarEmpleado());
    btnEliminar.addActionListener(e -> eliminarEmpleado());
    btnLimpiar.addActionListener(e -> limpiarCampos());
    btnListar.addActionListener(e -> listarEmpleados());

    tabla.getSelectionModel().addListSelectionListener(e -> cargarDatosSeleccion());
  }

  private void agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String label, JTextField campo) {
    gbc.gridx = 0;
    gbc.gridy = fila;
    panel.add(new JLabel(label), gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    panel.add(campo, gbc);
  }

  // ==================================
  // VALIDACIONES
  // ==================================

  private boolean validarCampos() {
    if (txtNombre.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
      txtNombre.requestFocus();
      return false;
    }

    if (txtApellido.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "El apellido es obligatorio.");
      txtApellido.requestFocus();
      return false;
    }

    if (txtDni.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "El DNI es obligatorio.");
      txtDni.requestFocus();
      return false;
    }

    if (!txtDni.getText().matches("\\d{8}")) {
      JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos.");
      txtDni.requestFocus();
      return false;
    }

    if (txtTelefono.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "El teléfono es obligatorio.");
      txtTelefono.requestFocus();
      return false;
    }

    if (!txtTelefono.getText().matches("\\d{9}")) {
      JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos.");
      txtTelefono.requestFocus();
      return false;
    }

    if (txtCargo.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "El cargo es obligatorio.");
      txtCargo.requestFocus();
      return false;
    }

    if (txtFecha.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "La fecha de contratación es obligatoria.");
      txtFecha.requestFocus();
      return false;
    }

    // Validar formato fecha
    try {
      LocalDate.parse(txtFecha.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "La fecha debe tener el formato YYYY-MM-DD.");
      txtFecha.requestFocus();
      return false;
    }

    return true;
  }

  // ==================================
  // CRUD
  // ==================================

  private void agregarEmpleado() {
    if (!validarCampos()) return;

    try {
      Empleado emp = new Empleado(
      0,
      txtNombre.getText(),
      txtApellido.getText(),
      txtDni.getText(),
      txtTelefono.getText(),
      txtCargo.getText(),
      LocalDate.parse(txtFecha.getText())
      );

      empleadoDAO.insertar(emp);
      listarEmpleados();
      limpiarCampos();

      JOptionPane.showMessageDialog(this, "Empleado registrado correctamente.");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al registrar: " + e.getMessage());
    }
  }

  private void actualizarEmpleado() {
    if (txtId.getText().isEmpty()) {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado.");
      return;
    }

    if (!validarCampos()) return;

    try {
      Empleado emp = new Empleado(
      Integer.parseInt(txtId.getText()),
      txtNombre.getText(),
      txtApellido.getText(),
      txtDni.getText(),
      txtTelefono.getText(),
      txtCargo.getText(),
      LocalDate.parse(txtFecha.getText())
      );

      empleadoDAO.actualizar(emp);
      listarEmpleados();
      limpiarCampos();

      JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente.");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
    }
  }

  private void eliminarEmpleado() {
    if (txtId.getText().isEmpty()) {
      JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado.");
      return;
    }

    int confirm = JOptionPane.showConfirmDialog(this,
    "¿Desea despedir este empleado?",
    "Confirmación",
    JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) return;

    try {
      empleadoDAO.eliminar(Integer.parseInt(txtId.getText()));
      listarEmpleados();
      limpiarCampos();

      JOptionPane.showMessageDialog(this, "Empleado despedido correctamente.");

    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
    }
  }

  private void listarEmpleados() {
    modelo.setRowCount(0);
    List<Empleado> lista = empleadoDAO.obtenerTodos();

    for (Empleado emp : lista) {
      modelo.addRow(new Object[]{
      emp.getId(),
      emp.getNombre(),
      emp.getApellido(),
      emp.getDni(),
      emp.getTelefono(),
      emp.getCargo(),
      emp.getFechaContratacion()
      });
    }
  }

  private void cargarDatosSeleccion() {
    int fila = tabla.getSelectedRow();
    if (fila == -1) return;

    txtId.setText(tabla.getValueAt(fila, 0).toString());
    txtNombre.setText(tabla.getValueAt(fila, 1).toString());
    txtApellido.setText(tabla.getValueAt(fila, 2).toString());
    txtDni.setText(tabla.getValueAt(fila, 3).toString());
    txtTelefono.setText(tabla.getValueAt(fila, 4).toString());
    txtCargo.setText(tabla.getValueAt(fila, 5).toString());
    txtFecha.setText(tabla.getValueAt(fila, 6).toString());
  }

  private void limpiarCampos() {
    txtId.setText("");
    txtNombre.setText("");
    txtApellido.setText("");
    txtDni.setText("");
    txtTelefono.setText("");
    txtCargo.setText("");
    txtFecha.setText("");
    tabla.clearSelection();
  }
}
