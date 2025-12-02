package com.wvl.stage4.test;

import com.wvl.stage4.database.ConnectionDB;

public class TestDB {
  public static void main(String[] args) {
    System.out.println(ConnectionDB.getConnection());
  }
}
