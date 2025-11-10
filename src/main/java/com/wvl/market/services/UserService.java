package com.wvl.market.services;

import com.wvl.market.database.MySQL;
import com.wvl.market.entity.User;

import java.sql.Connection;

public class UserService {
  public  UserService() {

  }

  public User getUser(String email, String password) {
    Connection conn = MySQL.getInstance().getConnection();

    return new User();
  }
}
