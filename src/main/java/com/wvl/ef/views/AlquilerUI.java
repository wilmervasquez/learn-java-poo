package com.wvl.ef.views;

import com.wvl.ef.dao.AlquilerDAO;
import com.wvl.ef.dao.ClienteDAO;
import com.wvl.ef.dao.PeliculaDAO;
import com.wvl.ef.models.Alquiler;
import com.wvl.ef.models.Cliente;
import com.wvl.ef.models.Pelicula;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.List;

public class AlquilerUI extends JFrame {
    private AlquilerDAO alquilerDAO = new AlquilerDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private PeliculaDAO peliculaDAO = new PeliculaDAO();

    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<Cliente> cbClientes;
    private JComboBox<Pelicula> cbPeliculas;
    private JTextField txtFechaAlq, txtFechaDev, txtPrecio, txtEstado;

    public AlquilerUI() {
        setTitle("Alquileres");
        setSize(900,480);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("Cliente"); l1.setBounds(20,20,80,25);
        JLabel l2 = new JLabel("Película"); l2.setBounds(340,20,80,25);
        JLabel l3 = new JLabel("Fecha Alq (yyyy-MM-dd)"); l3.setBounds(20,60,160,25);
        JLabel l4 = new JLabel("Fecha Dev (yyyy-MM-dd)"); l4.setBounds(20,100,160,25);
        JLabel l5 = new JLabel("Precio"); l5.setBounds(340,60,80,25);
        JLabel l6 = new JLabel("Estado"); l6.setBounds(340,100,80,25);

        cbClientes = new JComboBox<>(); cbClientes.setBounds(100,20,220,25);
        cbPeliculas = new JComboBox<>(); cbPeliculas.setBounds(420,20,300,25);
        txtFechaAlq = new JTextField(); txtFechaAlq.setBounds(180,60,140,25);
        txtFechaDev = new JTextField(); txtFechaDev.setBounds(180,100,140,25);
        txtPrecio = new JTextField(); txtPrecio.setBounds(420,60,140,25);
        txtEstado = new JTextField(); txtEstado.setBounds(420,100,140,25);

        JButton btnAgregar = new JButton("Agregar"); btnAgregar.setBounds(600,60,120,25);
        JButton btnEditar  = new JButton("Editar");  btnEditar.setBounds(600,95,120,25);
        JButton btnEliminar= new JButton("Eliminar");btnEliminar.setBounds(740,60,120,25);
        JButton btnRefrescar = new JButton("Refrescar"); btnRefrescar.setBounds(740,95,120,25);

        modelo = new DefaultTableModel(new String[]{"ID","Cliente","Pelicula","FechaAlq","FechaDev","Precio","Estado"},0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabla = new JTable(modelo);
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20,150,840,280);

        add(l1); add(l2); add(l3); add(l4); add(l5); add(l6);
        add(cbClientes); add(cbPeliculas); add(txtFechaAlq); add(txtFechaDev); add(txtPrecio); add(txtEstado);
        add(btnAgregar); add(btnEditar); add(btnEliminar); add(btnRefrescar);
        add(sp);

        cargarCombos();
        cargarTabla();

        btnAgregar.addActionListener(e -> {
            Cliente cli = (Cliente) cbClientes.getSelectedItem();
            Pelicula pel = (Pelicula) cbPeliculas.getSelectedItem();
            if (cli == null || pel == null) { JOptionPane.showMessageDialog(this,"Selecciona cliente y película"); return; }

            LocalDate fa = parseDateOrNull(txtFechaAlq.getText());
            LocalDate fd = parseDateOrNull(txtFechaDev.getText());
            double precio = parseDoubleOrZero(txtPrecio.getText());
            String estado = txtEstado.getText();

            Alquiler a = new Alquiler(cli.getId(), pel.getId(), fa != null ? fa : LocalDate.now(), fd, precio, estado);
            Alquiler creado = alquilerDAO.create(a);
            if (creado != null) { cargarTabla(); JOptionPane.showMessageDialog(this,"Alquiler creado"); }
            else JOptionPane.showMessageDialog(this,"Error al crear alquiler");
        });

        btnEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                int id = Integer.parseInt(modelo.getValueAt(fila,0).toString());
                Cliente cli = (Cliente) cbClientes.getSelectedItem();
                Pelicula pel = (Pelicula) cbPeliculas.getSelectedItem();
                LocalDate fa = parseDateOrNull(txtFechaAlq.getText());
                LocalDate fd = parseDateOrNull(txtFechaDev.getText());
                double precio = parseDoubleOrZero(txtPrecio.getText());
                String estado = txtEstado.getText();

                Alquiler a = new Alquiler(id, cli.getId(), pel.getId(), fa, fd, precio, estado);
                boolean ok = alquilerDAO.update(a);
                if (ok) { cargarTabla(); JOptionPane.showMessageDialog(this,"Alquiler actualizado"); }
                else JOptionPane.showMessageDialog(this,"Error al actualizar");
            } else JOptionPane.showMessageDialog(this,"Selecciona una fila");
        });

        btnEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                int id = Integer.parseInt(modelo.getValueAt(fila,0).toString());
                boolean ok = alquilerDAO.delete(id);
                if (ok) { cargarTabla(); JOptionPane.showMessageDialog(this,"Eliminado"); }
                else JOptionPane.showMessageDialog(this,"Error al eliminar");
            } else JOptionPane.showMessageDialog(this,"Selecciona una fila");
        });

        btnRefrescar.addActionListener(e -> { cargarCombos(); cargarTabla(); });

        tabla.getSelectionModel().addListSelectionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                int cliId = Integer.parseInt(modelo.getValueAt(fila,1).toString().split("-")[0].trim());
                int pelId = Integer.parseInt(modelo.getValueAt(fila,2).toString().split("-")[0].trim());
                selectCombo(clienteDAO.findById(cliId), peliculaDAO.findById(pelId));
                txtFechaAlq.setText(modelo.getValueAt(fila,3).toString());
                txtFechaDev.setText(modelo.getValueAt(fila,4) != null ? modelo.getValueAt(fila,4).toString() : "");
                txtPrecio.setText(modelo.getValueAt(fila,5).toString());
                txtEstado.setText(modelo.getValueAt(fila,6).toString());
            }
        });
    }

    private void selectCombo(Cliente c, Pelicula p) {
        if (c != null) {
            for (int i = 0; i < cbClientes.getItemCount(); i++) if (cbClientes.getItemAt(i).getId() == c.getId()) { cbClientes.setSelectedIndex(i); break; }
        }
        if (p != null) {
            for (int i = 0; i < cbPeliculas.getItemCount(); i++) if (cbPeliculas.getItemAt(i).getId() == p.getId()) { cbPeliculas.setSelectedIndex(i); break; }
        }
    }

    private LocalDate parseDateOrNull(String s) {
        try { if (s == null || s.trim().isEmpty()) return null; return LocalDate.parse(s.trim()); }
        catch (Exception ex) { return null; }
    }

    private double parseDoubleOrZero(String s) {
        try { if (s == null || s.trim().isEmpty()) return 0.0; return Double.parseDouble(s.trim()); }
        catch (Exception ex) { return 0.0; }
    }

    private void cargarCombos() {
        cbClientes.removeAllItems();
        List<Cliente> clientes = clienteDAO.findAll();
        if (clientes != null) for (Cliente c : clientes) cbClientes.addItem(c);

        cbPeliculas.removeAllItems();
        List<Pelicula> peliculas = peliculaDAO.findAll();
        if (peliculas != null) for (Pelicula p : peliculas) cbPeliculas.addItem(p);

        // To show useful text in combobox, override toString in Cliente and Pelicula models:
        // Cliente.toString() -> id + " - " + nombres + " " + apellidos
        // Pelicula.toString() -> id + " - " + titulo
    }

    void cargarTabla() {
        modelo.setRowCount(0);
        List<Alquiler> lista = alquilerDAO.findAll();
        if (lista != null) {
            for (Alquiler a : lista) {
                Cliente c = clienteDAO.findById(a.getClienteId());
                Pelicula p = peliculaDAO.findById(a.getPeliculaId());
                String clienteText = (c != null) ? (c.getId() + " - " + c.getNombres() + " " + c.getApellidos()) : String.valueOf(a.getClienteId());
                String peliculaText = (p != null) ? (p.getId() + " - " + p.getTitulo()) : String.valueOf(a.getPeliculaId());
                modelo.addRow(new Object[]{
                        a.getId(),
                        clienteText,
                        peliculaText,
                        a.getFechaAlquiler() != null ? a.getFechaAlquiler().toString() : "",
                        a.getFechaDevolucion() != null ? a.getFechaDevolucion().toString() : "",
                        a.getPrecio(),
                        a.getEstado()
                });
            }
        }
    }
}
