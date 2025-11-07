package com.wvl.negocio.vista;

import com.wvl.negocio.controlador.ProductoControlador;
import com.wvl.negocio.entidades.Producto;
import com.wvl.negocio.vista.componentes.CardProduct;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
  public PanelProductos(ProductoControlador controlador){
    setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

    for(Producto producto : controlador.getProductos()) {
      add(new CardProduct(
        producto.getImagen(),
        producto.getNombre(),
        producto.getPrecioUnitario()
      ));
    }
  }
}
