package com.wvl.market.views.button;

import javax.swing.*;
import java.awt.*;

public class ButtonSecondary extends JButton {
  public ButtonSecondary(String text) {
    super(text);
    setFont(new Font("Geist", Font.BOLD, 14));
    setBackground(Color.decode("#d1d5dc"));
    setForeground(Color.BLACK);
  }
}
