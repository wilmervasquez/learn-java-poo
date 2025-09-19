package com.wvl.gui;

import javax.swing.*;

public class Main {

  public static void main(String[] args) {
    WindowView windowView = new WindowView();

    JTextField textarea  = new JTextField();
    textarea.setEditable(true);

    JButton button  = new JButton("Seleccionar");

    windowView.add(button);
    windowView.add(textarea);
  }
}
