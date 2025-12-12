package com.wvl.ef.models;

public class Persona {
  protected String nombres;
  protected String apellidos;

  public Persona() {}
  public Persona(String nombres, String apellidos) {
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

  public String getNombres() { return nombres; }
  public String getApellidos() { return apellidos; }
  
  public void setNombres(String nombres) { this.nombres = nombres; }
  public void setApellidos(String apellidos) { this.apellidos = apellidos; }
}
