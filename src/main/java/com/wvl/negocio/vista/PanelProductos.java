package com.wvl.negocio.vista;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;
import com.wvl.negocio.vista.componentes.CardProduct;
import com.wvl.negocio.vista.layout.WrapLayout;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
  private final ProductoControlador controlador;
  private final JPanel panelContenido; // panel interno con las tarjetas

  public PanelProductos(ProductoControlador controlador) {
    this.controlador = controlador;
    setLayout(new BorderLayout());

    // Crear panel interno con WrapLayout
    panelContenido = new JPanel(new WrapLayout(FlowLayout.CENTER, 20, 20));
    panelContenido.setBackground(Color.WHITE);

    // Cargar productos iniciales
    cargarProductos();

    // Scroll solo vertical
    JScrollPane scrollPane = new JScrollPane(panelContenido);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    add(scrollPane, BorderLayout.CENTER);
  }

  /** 🔹 Carga todos los productos del controlador en el panel */
  private void cargarProductos() {
    panelContenido.removeAll(); // Limpiar productos previos

    for (Producto producto : controlador.getProductos()) {
        panelContenido.add(new CardProduct(
        producto.getImagen(),
        producto.getNombre(),
        producto.getPrecioUnitario()
      ));
    }

    // Refrescar la interfaz
    panelContenido.revalidate();
    panelContenido.repaint();
  }

  public void actualizarVista() {
    cargarProductos();
  }

  public void actualizarProducto(Producto productoActualizado) {
    // Buscar el producto en el controlador y recargar todo
    // (más simple para mantener coherencia visual)
    cargarProductos();
  }
}
