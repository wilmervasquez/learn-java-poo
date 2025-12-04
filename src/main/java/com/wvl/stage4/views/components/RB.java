package com.wvl.stage4.views.components;

import java.awt.*;
import javax.swing.*;

public class RB extends JButton {

  private int radius = 8;

  public RB(String text) {
    super(text);
    setContentAreaFilled(false); // evita fondo default
    setFocusPainted(false);
  }

  public void setRadius(int radius) {
    this.radius = radius;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Fondo
    g2.setColor(getBackground());
    g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

    super.paintComponent(g);
    g2.dispose();
  }

  @Override
  protected void paintBorder(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    g2.setColor(new Color(0, 255, 0, 0));
    g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

    g2.dispose();
  }
}

