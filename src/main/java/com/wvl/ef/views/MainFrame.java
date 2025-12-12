package com.wvl.ef.views;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

  public MainFrame() {
    setTitle("Sistema de Alquiler de Películas");
    setSize(400, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 1, 10, 10));

    JButton btnClientes = new JButton("Gestionar Clientes");
    JButton btnPeliculas = new JButton("Gestionar Películas");
    JButton btnAlquileres = new JButton("Gestionar Alquileres");

    add(btnClientes);
    add(btnPeliculas);
    add(btnAlquileres);

    btnClientes.addActionListener(e -> new ClienteUI().setVisible(true));
    btnPeliculas.addActionListener(e -> new PeliculaUI().setVisible(true));
    btnAlquileres.addActionListener(e -> new AlquilerUI().setVisible(true));
  }
}