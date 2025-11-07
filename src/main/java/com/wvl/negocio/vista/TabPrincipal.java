package com.wvl.negocio.vista;

import javax.swing.*;

public class TabPrincipal extends JTabbedPane {
  public TabPrincipal(JPanel panel1, JPanel panel2, JPanel panel3) {
    // Crear el componente de pestañas
    super();

    // Agregar las pestañas al tabbedPane
    addTab("Productos", panel1);
    addTab("Agregar producto", panel2);
    addTab("Actualizar producto", panel3);
    addTab("Tabla de Producto", panel3);
  }
}
