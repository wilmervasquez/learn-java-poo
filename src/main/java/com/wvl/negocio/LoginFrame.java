package com.wvl.negocio;

import com.wvl.negocio.entidades.Usuario;
import com.wvl.negocio.controlador.UsuarioControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
  private JTextField txtEmail;
  private JPasswordField txtPassword;
  private JButton loginButton;
  private UsuarioControlador controlador;
  public LoginFrame() {
    Font font = new Font("Geist", Font.BOLD, 14);
    this.controlador = new UsuarioControlador();

    setSize(600, 400);
    setTitle("Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);

    JLabel bien = new JLabel("Bienvenido", SwingConstants.CENTER);
    bien.setBounds(150, 30, 300, 25);
    bien.setFont(new Font("Geist", Font.BOLD, 36));
    add(bien);

    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setBounds(150, 80, 80, 25);
    emailLabel.setFont(font);
    txtEmail = new JTextField();
    txtEmail.setBounds(150, 100, 300, 36);
    add(emailLabel);
    add(txtEmail);

    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(150, 150, 80, 25);
    passwordLabel.setFont(font);
    txtPassword = new JPasswordField();
    txtPassword.setBounds(150, 170, 300, 36);
    add(passwordLabel);
    add(txtPassword);


    loginButton = new JButton("Iniciar Sesion");
    loginButton.setBounds(150, 230, 300, 36);
    add(loginButton);

    JButton btn = new JButton("Continuar como empleado");
    btn.setBounds(150, 470, 300, 36);
    btn.setBackground(Color.BLACK);
    btn.setForeground(Color.WHITE);
    add(btn);

    loginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        Usuario usuario = controlador.autenticar(email, password);

        if (usuario != null) {
          JOptionPane.showMessageDialog(null, "Bienvenido " +  usuario.getNombre());
          abrirVentanaPrincipal();
        } else {
          JOptionPane.showMessageDialog(null, "Correo o contraseña incorrecta");
        }
      }
    });
  }

  void abrirVentanaPrincipal() {
    dispose();
    new VIstaProductos().interfaz();
  }
}