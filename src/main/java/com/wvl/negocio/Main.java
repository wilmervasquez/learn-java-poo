package com.wvl.negocio;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
  }
}
