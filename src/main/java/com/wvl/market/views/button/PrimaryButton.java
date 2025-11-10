package com.wvl.market.views.button;

import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {
  public PrimaryButton(String text) {
    super(text);

    setFont(new Font("Geist", Font.BOLD, 14));
    setBackground(Color.decode("#009689"));
    setForeground(Color.white);
  }
}
