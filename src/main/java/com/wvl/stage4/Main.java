package com.wvl.stage4;

import com.wvl.stage4.views.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    UIManager.put("defaultFont", new Font("Geist", Font.PLAIN, 14));

    // Iniciar app
    SwingUtilities.invokeLater(() -> {
      new MainFrame().setVisible(true);
    });

  }
}
