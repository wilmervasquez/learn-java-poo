package com.wvl.db;

import java.util.Scanner;

public class Scan {
  Scanner sc = new Scanner(System.in);

  String next(String label) {
    System.out.print(label);
    return sc.next();
  }
  int nextInt(String label) {
    System.out.print(label);
    return sc.nextInt();
  }
}
