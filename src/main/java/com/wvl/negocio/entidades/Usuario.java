package com.wvl.negocio.entidades;

public class Usuario extends Persona {
  String nombre;
  String email;
  String password;

  public Usuario(String nombre, String email, String password) {
    super();
    this.nombre = nombre;
    this.email = email;
    this.password = password;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
