package com.wvl.negocio;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;
import com.wvl.negocio.vista.PanelAgregarProducto;
import com.wvl.negocio.vista.PanelProductos;
import com.wvl.negocio.vista.TabPrincipal;
import com.wvl.negocio.vista.TablaProductos;
import com.wvl.negocio.vista.componentes.CardProduct;

import javax.swing.*;
import java.awt.*;

public class Main {
  public  static void main(String[] args) {

      SwingUtilities.invokeLater(() -> {
        ProductoControlador productoControlador = new ProductoControlador();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        // tabs
        JPanel panel1 = new PanelProductos(productoControlador);
        PanelAgregarProducto panel2 = new PanelAgregarProducto(productoControlador);
        TablaProductos panelTablaProductos = new TablaProductos(productoControlador);

        TabPrincipal  tabPrincipal = new TabPrincipal(panel1, panel2, panelTablaProductos);

        panel2.setProducto(productoControlador.getProductos().getFirst());
        panelTablaProductos.setProductos(productoControlador.getProductos());

        frame.add(tabPrincipal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      });
  }
}
