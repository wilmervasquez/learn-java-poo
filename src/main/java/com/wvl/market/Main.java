package com.wvl.market;

import com.wvl.market.views.frame.MainFrame;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new MainFrame());
  }
}
