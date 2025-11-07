package com.wvl.negocio;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;
import com.wvl.negocio.vista.TabPrincipal;
import com.wvl.negocio.vista.componentes.CardProduct;

import javax.swing.*;
import java.awt.*;

public class Main {
  public  static void main(String[] args) {

      SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        frame.getContentPane().setBackground(Color.WHITE);

        TabPrincipal  tabPrincipal = new TabPrincipal();

        ProductoControlador productoControlador = new ProductoControlador();
        for(Producto producto : productoControlador.getProductos()) {
          frame.add(new CardProduct(
            producto.getImagen(),
            producto.getNombre(),
            producto.getPrecioUnitario()
          ));
        }
        for(Producto producto : productoControlador.getProductos()) {
          frame.add(new CardProduct(
            producto.getImagen(),
            producto.getNombre(),
            producto.getPrecioUnitario()
          ));
        }
        for(Producto producto : productoControlador.getProductos()) {
          frame.add(new CardProduct(
          producto.getImagen(),
          producto.getNombre(),
          producto.getPrecioUnitario()
          ));
        }
        for(Producto producto : productoControlador.getProductos()) {
          frame.add(new CardProduct(
          producto.getImagen(),
          producto.getNombre(),
          producto.getPrecioUnitario()
          ));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


      });


  }
}
