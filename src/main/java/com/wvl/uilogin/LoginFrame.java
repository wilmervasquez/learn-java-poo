package com.wvl.uilogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
  private JTextField txtEmail;
  private JPasswordField txtPassword;
  private JButton loginButton;
  private UsuarioControlador controlador;
  public LoginFrame() {
    this.controlador = new UsuarioControlador();

    setSize(600, 400);
    setTitle("Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setBounds(50, 30, 80, 14);
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setBounds(50, 90, 80, 14);

    txtEmail = new JTextField();
    txtEmail.setBounds(150, 30, 80, 20);
    txtPassword = new JPasswordField();
    txtPassword.setBounds(150, 90, 200, 25);

    add(emailLabel);
    add(txtEmail);
    add(passwordLabel);
    add(txtPassword);

    loginButton = new JButton("Enviar");
    loginButton.setBounds(150, 110, 100, 30);
    add(loginButton);

    loginButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        Usuario usuario = controlador.autenticar(email, password);

        if (usuario != null) {
          JOptionPane.showMessageDialog(null, "Bienvenido " +  usuario.getNombre());
          abrirVentanaPrincipal();
        } else {
          JOptionPane.showMessageDialog(null, "Usuario invalido!");
        }
      }
    });
  }

  void abrirVentanaPrincipal() {
    dispose();
    setVisible(true);
  }

}
