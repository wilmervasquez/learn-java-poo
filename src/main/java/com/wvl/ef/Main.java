package com.wvl.ef;

import com.wvl.ef.views.MainFrame;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      new MainFrame().setVisible(true);
    });
  }
}
