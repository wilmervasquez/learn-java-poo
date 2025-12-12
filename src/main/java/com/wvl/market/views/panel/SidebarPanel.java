package com.wvl.market.views.panel;

import com.wvl.market.views.Icon;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {
  public SidebarPanel() {
    setLayout(new GridLayout(14, 3));

    add(createButton(Icon.get("LucideCircleUserRound"), "Usuarios"));
    add(createButton(Icon.get("LucidePlay"), "Productos"));
    add(createButton(Icon.get("LucideBarChartHorizontalBig"), "Ventas"));
    add(createButton(Icon.get("LucideBox"), "Compras"));
    add(createButton(Icon.get("LucidePlay"), "Cappital"));
    add(createButton(Icon.get("LucidePlay"), "Conset"));
    add(createButton(Icon.get("LucidePlay"), "Reservas"));
    add(createButton(Icon.get("LucidePlay"), "Configuraciones"));

  }
  public JButton createButton(ImageIcon icon, String text) {
    JButton btnAddProducts = new JButton(text);
    btnAddProducts.setIcon(icon);
    btnAddProducts.setBackground(Color.decode("#EEEEEE"));
    btnAddProducts.setBorderPainted(false);
    btnAddProducts.setFocusPainted(false);
    return btnAddProducts;
  }
}
