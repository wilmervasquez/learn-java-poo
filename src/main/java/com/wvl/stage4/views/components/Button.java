package com.wvl.stage4.views.components;

import java.awt.*;
import javax.swing.*;

public class Button extends JButton {
  public Button(String text) {
    super(text);
    setOpaque(false);
    setContentAreaFilled(false); // evita fondo default
    setFocusPainted(false);
    setBackground(Colors.PRIMARY);
    setForeground(Color.WHITE);
    setPreferredSize(new Dimension(getPreferredSize().width, 32));
    setBorderPainted(false);
    setFont(Fonts.SANS_SERIF);
    addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseEntered(java.awt.event.MouseEvent e) {
        setBackground(Colors.PRIMARY_DARK);

      }

      @Override
      public void mouseExited(java.awt.event.MouseEvent e) {
        setBackground(Colors.PRIMARY);
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Fondo
    g2.setColor(getBackground());
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

    super.paintComponent(g);

    // Borde
    g2.setColor(Colors.PRIMARY_DARK);
    g2.setStroke(new BasicStroke(1));
    g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 8, 8);

    g2.dispose();

  }


}

