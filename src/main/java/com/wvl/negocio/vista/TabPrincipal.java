package com.wvl.negocio.vista;

import javax.swing.*;
import java.awt.*;

public class TabPrincipal {
  public TabPrincipal(JPanel panel, JPanel panel1, JPanel panel2) {
    // Crear el componente de pestañas
    JTabbedPane tabbedPane = new JTabbedPane();

    JPanel panel3 = new JPanel();

    // Agregar las pestañas al tabbedPane
    tabbedPane.addTab("Productos", panel1);
    tabbedPane.addTab("Agregar producto", panel2);
    tabbedPane.addTab("Actualizar producto", panel3);

  }
}
