package com.wvl.negocio;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.vista.PanelAgregarProducto;
import com.wvl.negocio.vista.PanelProductos;
import com.wvl.negocio.vista.TabPrincipal;
import com.wvl.negocio.vista.TablaProductos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VIstaProductos {
  public void interfaz() {

      SwingUtilities.invokeLater(() -> {
        ProductoControlador productoControlador = new ProductoControlador();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        // tabs
        PanelProductos panel1 = new PanelProductos(productoControlador);
        PanelAgregarProducto panel2 = new PanelAgregarProducto(productoControlador);
        TablaProductos panelTablaProductos = new TablaProductos(productoControlador);

        TabPrincipal  tabPrincipal = new TabPrincipal(panel1, panel2, panelTablaProductos);
        tabPrincipal.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent e) {
            int index = tabPrincipal.getSelectedIndex();
            String titulo = tabPrincipal.getTitleAt(index);
            System.out.println("Pestaña actual: " + titulo);

            panel1.actualizarVista();
            panelTablaProductos.setProductos(productoControlador.getProductos());
          }
        });


        panelTablaProductos.setProductos(productoControlador.getProductos());

        frame.add(tabPrincipal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      });
  }
}
