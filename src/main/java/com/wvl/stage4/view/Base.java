package com.wvl.stage4.view;

import javax.swing.*;
import java.awt.*;

public class Base {
  static JButton createButtonBrand(String text) {
    JButton button = new JButton(text);
    button.setBackground(Color.decode("#00bc7d"));
    button.setForeground(Color.WHITE);
    return button;
  }
  static JButton createButtonDestructive(String text) {
    JButton button = new JButton(text);
    button.setBackground(Color.decode("#fb2c36"));
    button.setForeground(Color.WHITE);
    return button;
  }
}
