package com.wvl.stage4.test;

import com.wvl.stage4.database.ConexionDB;

public class TestDB {
  public static void main(String[] args) {
    System.out.println(ConexionDB.getConnection());
  }
}
