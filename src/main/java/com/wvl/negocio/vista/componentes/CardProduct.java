package com.wvl.negocio.vista.componentes;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.URL;

public class CardProduct extends JPanel {
  public CardProduct(String imageUrl, String name, double price) {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(200, 280));
    setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
    setBackground(Color.WHITE);

    try {
      // Cargar imagen desde internet
      URL url = new URI(imageUrl).toURL();
      ImageIcon icon = new ImageIcon(url);
      Image scaled = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
      JLabel imageLabel = new JLabel(new ImageIcon(scaled));
      imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
      add(imageLabel, BorderLayout.NORTH);
    } catch (Exception e) {
      add(new JLabel("Imagen no disponible"), BorderLayout.NORTH);
    }

    // Panel inferior (nombre + precio + botón)
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.setBackground(Color.WHITE);
    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel nameLabel = new JLabel(name);
    nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel priceLabel = new JLabel("S/ " + price);
    priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
    priceLabel.setForeground(new Color(0, 128, 0));
    priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton buyButton = new JButton("Comprar");
    buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    infoPanel.add(nameLabel);
    infoPanel.add(Box.createVerticalStrut(5));
    infoPanel.add(priceLabel);
    infoPanel.add(Box.createVerticalStrut(10));
    infoPanel.add(buyButton);

    add(infoPanel, BorderLayout.CENTER);
  }

 }