package com.wvl.ef.views;

import com.wvl.ef.dao.PeliculaDAO;
import com.wvl.ef.models.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PeliculaUI extends JFrame {

    private PeliculaDAO dao = new PeliculaDAO();
    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField txtCodigo, txtTitulo, txtGenero, txtDur;

    public PeliculaUI() {
        setTitle("Películas");
        setSize(760,420);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Código"); l1.setBounds(20,20,100,25);
        JLabel l2 = new JLabel("Título");  l2.setBounds(20,50,100,25);
        JLabel l3 = new JLabel("Género");  l3.setBounds(20,80,100,25);
        JLabel l4 = new JLabel("Duración (min)"); l4.setBounds(20,110,120,25);

        txtCodigo = new JTextField(); txtCodigo.setBounds(140,20,240,25);
        txtTitulo = new JTextField();  txtTitulo.setBounds(140,50,240,25);
        txtGenero = new JTextField();  txtGenero.setBounds(140,80,240,25);
        txtDur    = new JTextField();  txtDur.setBounds(140,110,240,25);

        JButton btnAgregar = new JButton("Agregar"); btnAgregar.setBounds(400,20,120,25);
        JButton btnEditar  = new JButton("Editar");  btnEditar.setBounds(400,55,120,25);
        JButton btnEliminar= new JButton("Eliminar");btnEliminar.setBounds(400,90,120,25);
        JButton btnRefrescar= new JButton("Refrescar"); btnRefrescar.setBounds(400,125,120,25);

        modelo = new DefaultTableModel(new String[]{"ID","Código","Título","Género","Duración"},0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tabla = new JTable(modelo);
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20,170,700,200);

        add(l1); add(l2); add(l3); add(l4);
        add(txtCodigo); add(txtTitulo); add(txtGenero); add(txtDur);
        add(btnAgregar); add(btnEditar); add(btnEliminar); add(btnRefrescar);
        add(sp);

        cargarTabla();

        // BOTON AGREGAR ===============================
        btnAgregar.addActionListener(e -> {
            String err = validarCampos();
            if (err != null) {
                JOptionPane.showMessageDialog(this, err, "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Integer dur = Integer.parseInt(txtDur.getText().trim());

            Pelicula p = new Pelicula(
                    txtCodigo.getText().trim(),
                    txtTitulo.getText().trim(),
                    txtGenero.getText().trim(),
                    dur
            );

            Pelicula creado = dao.create(p);
            if (creado != null) {
                cargarTabla();
                limpiar();
                JOptionPane.showMessageDialog(this,"Película agregada");
            } else {
                JOptionPane.showMessageDialog(this,"Error al agregar");
            }
        });

        // BOTON EDITAR ================================
        btnEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(this, "Selecciona una fila", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String err = validarCampos();
            if (err != null) {
                JOptionPane.showMessageDialog(this, err, "Validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int id = Integer.parseInt(modelo.getValueAt(fila,0).toString());
            Integer dur = Integer.parseInt(txtDur.getText().trim());

            Pelicula p = new Pelicula(
                    id,
                    txtCodigo.getText().trim(),
                    txtTitulo.getText().trim(),
                    txtGenero.getText().trim(),
                    dur
            );

            boolean ok = dao.update(p);
            if (ok) {
                cargarTabla();
                JOptionPane.showMessageDialog(this,"Actualizado");
            } else {
                JOptionPane.showMessageDialog(this,"Error al actualizar");
            }
        });

        // BOTON ELIMINAR ==============================
        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(this,"Selecciona una fila");
                return;
            }

            int id = Integer.parseInt(modelo.getValueAt(fila,0).toString());
            boolean ok = dao.delete(id);

            if (ok) {
                cargarTabla();
                JOptionPane.showMessageDialog(this,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(this,"Error al eliminar");
            }
        });

        // BOTON REFRESCAR =============================
        btnRefrescar.addActionListener(e -> cargarTabla());

        // AL SELECCIONAR UNA FILA =====================
        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                txtCodigo.setText(modelo.getValueAt(fila,1).toString());
                txtTitulo.setText(modelo.getValueAt(fila,2).toString());
                txtGenero.setText(modelo.getValueAt(fila,3).toString());
                txtDur.setText(modelo.getValueAt(fila,4) != null ? modelo.getValueAt(fila,4).toString() : "");
            }
        });
    }

    // VALIDACIÓN DE CAMPOS ===================
    private String validarCampos() {
        String codigo = txtCodigo.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String genero = txtGenero.getText().trim();
        String dur = txtDur.getText().trim();

        if (codigo.isEmpty() || codigo.length() < 2)
            return "El código es obligatorio (mínimo 2 caracteres).";

        if (titulo.isEmpty() || titulo.length() < 2)
            return "El título es obligatorio (mínimo 2 caracteres).";

        if (genero.isEmpty())
            return "El género es obligatorio.";

        if (dur.isEmpty())
            return "La duración es obligatoria.";

        if (!dur.matches("\\d+"))
            return "La duración debe ser un número entero.";

        int d = Integer.parseInt(dur);
        if (d <= 0)
            return "La duración debe ser mayor que 0.";

        return null; // OK
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtGenero.setText("");
        txtDur.setText("");
        tabla.clearSelection();
    }

    void cargarTabla() {
        modelo.setRowCount(0);
        List<Pelicula> lista = dao.findAll();

        if (lista != null) {
            for (Pelicula p : lista) {
                modelo.addRow(new Object[]{
                        p.getId(),
                        p.getCodigo(),
                        p.getTitulo(),
                        p.getGenero(),
                        p.getDuracion()
                });
            }
        }
    }
}
