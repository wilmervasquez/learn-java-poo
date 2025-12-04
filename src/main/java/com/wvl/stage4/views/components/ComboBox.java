package com.wvl.stage4.views.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBox<E> extends JComboBox<E> {

  private Color normalColor = Color.WHITE;
  private Color hoverColor = new Color(230, 240, 255);
  private Color borderColor = new Color(150, 150, 150);

  private boolean hovered = false;
  private int radius = 15;

  public ComboBox(E[] items) {
    super(items);
    setOpaque(false);

    // Detectar hover
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        hovered = true;
        repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        hovered = false;
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Color de fondo según hover
    g2.setColor(hovered ? hoverColor : normalColor);
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

    // Borde
    g2.setColor(borderColor);
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

    g2.dispose();

    super.paintComponent(g);
  }
}
