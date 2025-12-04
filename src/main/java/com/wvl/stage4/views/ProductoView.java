package com.wvl.stage4.views;

import com.wvl.stage4.dao.ProductoDAO;
import com.wvl.stage4.dao.CategoriaDAO;
import com.wvl.stage4.models.Producto;
import com.wvl.stage4.models.Categoria;
import com.wvl.stage4.views.components.Button;
import com.wvl.stage4.views.components.ComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import com.wvl.stage4.views.components.*;

public class ProductoView extends JPanel {

  private JTable tablaProductos;
  private DefaultTableModel tableModel;
  private Button btnCargar, btnAgregar, btnEliminar;
  private ProductoDAO productoDAO;
  private JComboBox<Categoria> comboFiltroCategoria;
  private JTextField txtFiltroNombre, txtFiltroMarca;
  private Button btnFiltrar, btnLimpiarFiltros;
  private Button btnAgregarCategoria;

  public ProductoView() {
    productoDAO = new ProductoDAO();
    setLayout(new BorderLayout());

    inicializarFiltros();
    inicializarTabla();
    inicializarComponentes();
    cargarProductos();
    String[] opciones = {"Perú", "México", "Argentina"};

    ComboBox<String> combo = new ComboBox<>(opciones);
    combo.setFont(Fonts.SANS_SERIF);
    combo.setPreferredSize(new Dimension(200, 35));

  }

  private void inicializarTabla() {
    String[] columnNames = {"ID", "SKU", "Nombre", "Marca", "Precio", "Cantidad", "Categoría"};
    tableModel = new DefaultTableModel(columnNames, 0);
    tablaProductos = new JTable(tableModel);
    add(new JScrollPane(tablaProductos), BorderLayout.CENTER);
  }

  /* ------------------ FILTROS ------------------ */
  private void inicializarFiltros() {
    JPanel panelFiltros = new JPanel(new GridLayout(2, 4, 10, 5));

    txtFiltroNombre = new JTextField();
    txtFiltroMarca = new JTextField();
    comboFiltroCategoria = new JComboBox<>();
    cargarCategoriasEnCombo(comboFiltroCategoria, true); // true agrega "Todos"

    btnFiltrar = new Button("Aplicar Filtro");
    btnLimpiarFiltros = new Button("Limpiar");

    panelFiltros.add(new JLabel("Nombre:"));
    panelFiltros.add(txtFiltroNombre);

    panelFiltros.add(new JLabel("Marca:"));
    panelFiltros.add(txtFiltroMarca);

    panelFiltros.add(new JLabel("Categoría:"));
    panelFiltros.add(comboFiltroCategoria);

    panelFiltros.add(btnFiltrar);
    panelFiltros.add(btnLimpiarFiltros);

    add(panelFiltros, BorderLayout.NORTH);

    btnFiltrar.addActionListener(e -> aplicarFiltro());
    btnLimpiarFiltros.addActionListener(e -> limpiarFiltros());
  }

  private void aplicarFiltro() {
    String filtroNombre = txtFiltroNombre.getText().trim().toLowerCase();
    String filtroMarca = txtFiltroMarca.getText().trim().toLowerCase();

    Categoria categoriaFiltro = (Categoria) comboFiltroCategoria.getSelectedItem();
    Integer idCategoria = categoriaFiltro.getId() != 0 ? categoriaFiltro.getId() : null;

      List<Producto> productos = productoDAO.obtenerTodos();
      tableModel.setRowCount(0);

      for (Producto p : productos) {
        boolean coincide = true;

        if (!filtroNombre.isEmpty() && !p.getNombre().toLowerCase().contains(filtroNombre))
          coincide = false;

        if (!filtroMarca.isEmpty() && !p.getMarca().toLowerCase().contains(filtroMarca))
          coincide = false;

        if (idCategoria != null && idCategoria != null && p.getCategoriaId() != idCategoria)
          coincide = false;

        if (coincide) {
          tableModel.addRow(new Object[]{
          p.getId(), p.getSku(), p.getNombre(), p.getMarca(),
          p.getPrecio(), p.getCantidad(), p.getCategoriaId()
          });
        }
      }


  }

  private void limpiarFiltros() {
    txtFiltroNombre.setText("");
    txtFiltroMarca.setText("");
    comboFiltroCategoria.setSelectedIndex(0);
    cargarProductos();
  }

  /* ------------------ BOTONES ------------------ */
  private void inicializarComponentes() {
    JPanel panelBotones = new JPanel();

    btnCargar = new Button("Cargar Productos");
    btnAgregar = new Button("Agregar Producto");
    btnEliminar = new Button("Eliminar Seleccionado");
    btnAgregarCategoria = new Button("Agregar Categoría");

    panelBotones.add(btnCargar);
    panelBotones.add(btnAgregar);
    panelBotones.add(btnEliminar);
    panelBotones.add(btnAgregarCategoria);

    add(panelBotones, BorderLayout.SOUTH);

    btnCargar.addActionListener(e -> cargarProductos());
    btnAgregar.addActionListener(e -> mostrarDialogoAgregar());
    btnEliminar.addActionListener(e -> eliminarProducto());
    btnAgregarCategoria.addActionListener(e -> mostrarDialogoAgregarCategoria());
  }

  /* ------------------ CARGAR CATEGORÍAS ------------------ */
  private void cargarCategoriasEnCombo(JComboBox<Categoria> combo, boolean incluirTodos) {
    combo.removeAllItems();

    if (incluirTodos) {
      Categoria todos = new Categoria();
      todos.setNombre("Todos");
      combo.addItem(todos);
    }

    List<Categoria> categorias = new CategoriaDAO().obtenerTodos();

    for (Categoria c : categorias) combo.addItem(c);
  }

  /* ------------------ CARGAR PRODUCTOS ------------------ */
  private void cargarProductos() {
    tableModel.setRowCount(0);

      List<Producto> productos = productoDAO.obtenerTodos();
      for (Producto p : productos) {
        tableModel.addRow(new Object[]{
          p.getId(),
          p.getSku(),
          p.getNombre(),
          p.getMarca(),
          p.getPrecio(),
          p.getCantidad(),
          p.getCategoria().getNombre()
        });
      }
  }

  private void mostrarDialogoAgregar() {

    JTextField txtSku = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtMarca = new JTextField();
    JTextField txtPrecio = new JTextField();
    JTextField txtCantidad = new JTextField();

    JComboBox<Categoria> comboCategoria = new JComboBox<>();
    cargarCategoriasEnCombo(comboCategoria, false);

    JPanel panel = new JPanel(new GridLayout(0, 2, 4,4));
    panel.add(new JLabel("SKU:")); panel.add(txtSku);
    panel.add(new JLabel("Nombre:")); panel.add(txtNombre);
    panel.add(new JLabel("Marca:")); panel.add(txtMarca);
    panel.add(new JLabel("Precio:")); panel.add(txtPrecio);
    panel.add(new JLabel("Cantidad:")); panel.add(txtCantidad);
    panel.add(new JLabel("Categoría:")); panel.add(comboCategoria);

    int result = JOptionPane.showConfirmDialog(this, panel, "Agregar Nuevo Producto",
    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {

      // ============================
      // VALIDACIONES
      // ============================

      String sku = txtSku.getText().trim();
      String nombre = txtNombre.getText().trim();
      String marca = txtMarca.getText().trim();
      String strPrecio = txtPrecio.getText().trim();
      String strCantidad = txtCantidad.getText().trim();
      Categoria categoria = (Categoria) comboCategoria.getSelectedItem();

      if (sku.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El SKU es obligatorio.");
        return;
      }

      if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El nombre es obligatorio.");
        return;
      }

      if (marca.isEmpty()) {
        JOptionPane.showMessageDialog(this, "La marca es obligatoria.");
        return;
      }

      double precio;
      try {
        precio = Double.parseDouble(strPrecio);
        if (precio <= 0) {
          JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0.");
          return;
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
        return;
      }

      int cantidad;
      try {
        cantidad = Integer.parseInt(strCantidad);
        if (cantidad < 0) {
          JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa.");
          return;
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.");
        return;
      }

      if (categoria == null || categoria.getId() == 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría válida.");
        return;
      }

      // ============================
      // REGISTRO
      // ============================

      try {
        Producto nuevo = new Producto();

        nuevo.setSku(sku);
        nuevo.setNombre(nombre);
        nuevo.setMarca(marca);
        nuevo.setPrecio(precio);
        nuevo.setCantidad(cantidad);
        nuevo.setCategoriaId(categoria.getId());

        productoDAO.insertar(nuevo);
        cargarProductos();

        JOptionPane.showMessageDialog(this, "Producto agregado con éxito.");

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al agregar producto: " + ex.getMessage(),
        "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  /* ------------------ AGREGAR CATEGORÍA ------------------ */
  private void mostrarDialogoAgregarCategoria() {
    JTextField txtNombreCategoria = new JTextField();

    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.add(new JLabel("Nombre Categoría:"));
    panel.add(txtNombreCategoria);

    int result = JOptionPane.showConfirmDialog(
    this, panel, "Agregar Nueva Categoría",
    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
    );

    if (result == JOptionPane.OK_OPTION) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        Categoria nueva = new Categoria();
        nueva.setNombre(txtNombreCategoria.getText().trim());

        categoriaDAO.insertar(nueva);

        JOptionPane.showMessageDialog(this, "Categoría agregada con éxito.");

        cargarCategoriasEnCombo(comboFiltroCategoria, true);
    }
  }

  /* ------------------ ELIMINAR PRODUCTO ------------------ */
  private void eliminarProducto() {
    int fila = tablaProductos.getSelectedRow();
    if (fila == -1) {
      JOptionPane.showMessageDialog(this, "Selecciona un producto para eliminar.",
      "Advertencia", JOptionPane.WARNING_MESSAGE);
      return;
    }

    try {
      int id = (int) tableModel.getValueAt(fila, 0);

      int confirm = JOptionPane.showConfirmDialog(
      this,
      "¿Seguro que deseas eliminar el producto ID: " + id + "?",
      "Confirmar Eliminación",
      JOptionPane.YES_NO_OPTION
      );

      if (confirm == JOptionPane.YES_OPTION) {
        productoDAO.eliminar(id);
        cargarProductos();
        JOptionPane.showMessageDialog(this, "Producto eliminado.");
      }

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage(),
      "Error DB", JOptionPane.ERROR_MESSAGE);
    }
  }
}
