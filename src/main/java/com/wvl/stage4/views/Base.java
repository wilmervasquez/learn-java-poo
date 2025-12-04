package com.wvl.stage4.views;

import com.wvl.stage4.views.components.RB;

import javax.swing.*;
import java.awt.*;

public class Base {
  static JButton createButtonBrand(String text) {
    JButton button = new RB(text);
    button.setForeground(Color.decode("#00bc7d"));
    return button;
  }
  static JButton createButtonDestructive(String text) {
    JButton button = new JButton(text);
    button.setBackground(Color.decode("#fb2c36"));
    button.setForeground(Color.WHITE);
    return button;
  }

}
