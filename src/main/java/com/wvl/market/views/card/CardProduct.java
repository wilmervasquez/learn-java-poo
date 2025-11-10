package com.wvl.market.views.card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CardProduct extends JPanel {


    public CardProduct(String tituloText, String descripcionText) {
      // Configuración básica del card
      this.setPreferredSize(new Dimension(200, 250));
      this.setBackground(Color.WHITE);
      this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

      // Sombra simulada (con margen y color de fondo en contenedor)
      this.setOpaque(true);

      // Contenido del card
      JLabel titulo = new JLabel(tituloText);
      titulo.setFont(new Font("Arial", Font.BOLD, 16));
      titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

      JLabel descripcion = new JLabel("<html><p style='text-align:center;'>" + descripcionText + "</p></html>");
      descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

      JButton boton = new JButton("Acción");
      boton.setAlignmentX(Component.CENTER_ALIGNMENT);

      // Espacios
      this.add(Box.createVerticalStrut(15));
      this.add(titulo);
      this.add(Box.createVerticalStrut(10));
      this.add(descripcion);
      this.add(Box.createVerticalGlue());
      this.add(boton);
      this.add(Box.createVerticalStrut(15));

      // Efecto hover
      this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
          setBackground(new Color(220, 220, 255)); // ligero cambio de color
          setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseExited(MouseEvent e) {
          setBackground(Color.WHITE);
          setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
      });
    }

    // Método para crear sombra realista (opcional)
    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // Dibujar fondo con bordes redondeados
      g2.setColor(getBackground());
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

      super.paintComponent(g);
    }
  }
