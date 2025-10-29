package com.wvl.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  private final EstudianteController controller;
  private DefaultTableModel tableModel;
  private JTable table;
  private JTextField txtCodigo, txtNombres, txtApellidos;
  public Main() {
    controller = new EstudianteController();
  }
  public void interfazEstuduante(){
    JFrame frame = new JFrame("Mi app");
    frame.setSize(600, 400);
    frame.setLayout(new BorderLayout());

    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);


    JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
    panelFormulario.setBackground(Color.GREEN);

    txtCodigo = new JTextField();
    txtNombres = new JTextField();
    txtApellidos = new JTextField();

    panelFormulario.add(new JLabel("Codigo: "));
    panelFormulario.add(txtCodigo);
    panelFormulario.add(new JLabel("Nombres: "));
    panelFormulario.add(txtNombres);
    panelFormulario.add(new JLabel("Apellidos: "));
    panelFormulario.add(txtApellidos);

    frame.add(panelFormulario,  BorderLayout.NORTH);


    JPanel panelBotones = new JPanel();

    JButton btnAgregar = new JButton("Agregar");
    JButton btnBuscar = new JButton("Buscar");
    JButton btnEditar = new JButton("Editar");
    JButton btnEliminar = new JButton("Eliminar");

    panelBotones.add(btnAgregar);
    panelBotones.add(btnBuscar);
    panelBotones.add(btnEditar);
    panelBotones.add(btnEliminar);

    frame.add(panelBotones,  BorderLayout.SOUTH);

    tableModel = new DefaultTableModel(new String[]{"Codigo", "Nombres", "Apellidos"}, 0);
    table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane,  BorderLayout.CENTER);

    // eventos
    btnAgregar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int codigo = Integer.parseInt(txtCodigo.getText());
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();

        Estudiante estudiante = new Estudiante(codigo, nombres, apellidos);

        controller.addEstudiante(estudiante);

        tableModel.addRow(new Object[]{codigo, nombres, apellidos});

        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
      }
    });

    btnBuscar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo para buscar: "));

        Estudiante estudiante = controller.buscarEstudiante(codigo);

        if(estudiante != null){
          JOptionPane.showMessageDialog(null, "Codigo: " + estudiante.getCodigo() + " \nNombre: " + estudiante.getNombres() + " \nApellidos: " + estudiante.getApellidos());
        } else {
          JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
        }
      }
    });

    btnEditar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo para editar: "));

        Estudiante estudiante = controller.buscarEstudiante(codigo);

        if(estudiante != null){
          estudiante.setCodigo(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo codigo: ")));
          estudiante.setNombres(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombres: "));
          estudiante.setApellidos(JOptionPane.showInputDialog(null, "Ingrese el nuevo apellidos: "));

          listarEstudiantes();
        } else {
          JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
        }
      }
    });

    btnEliminar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo para eliminar: "));

        controller.eliminarEstudiante(codigo);
        listarEstudiantes();
      }
    });
  }

  public void listarEstudiantes() {
    tableModel.setRowCount(0);

    for (Estudiante estudiante: controller.listarEstudiantes()) {
      tableModel.addRow(new Object[]{
        estudiante.getCodigo(),
        estudiante.getNombres(),
        estudiante.getApellidos()
      });
    }
  }
  public static void main(String[] args) {
    Main main = new Main();
    main.interfazEstuduante();
  }
}
