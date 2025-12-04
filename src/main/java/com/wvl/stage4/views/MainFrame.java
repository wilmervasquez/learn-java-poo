package com.wvl.stage4.views;

import javax.swing.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Sistema ERP - Gestión Integral");
    setSize(900, 650);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JTabbedPane pestanas = new JTabbedPane();

    pestanas.addTab("📦 Inventario", new ProductoView());
    pestanas.addTab("💰 Reporte de Ventas", new PanelReporteVentas());
    JPanel panelEmpleados = new JPanel();
    panelEmpleados.add(new EmpleadoView());
    pestanas.addTab("👨‍💼 Empleados", panelEmpleados);

    add(pestanas);
  }
}