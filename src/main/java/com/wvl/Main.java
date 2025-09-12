package com.wvl;

import javax.swing.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println(Math.sin(Math.toRadians(60)));

    String bug = JOptionPane.showInputDialog("Ingrese su nombre: ");
    String bug2 = JOptionPane.showInputDialog("Ingrese su nombre: ");

    System.out.println(bug);
  }
}