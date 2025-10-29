package com.wvl.ui;

public class Estudiante {
  private int codigo;
  private String nombres;
  private String apellidos;
  public Estudiante() { }
  public Estudiante (int codigo, String nombres, String apellidos) {
    this.codigo = codigo;
    this.nombres = nombres;
    this.apellidos = apellidos;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
}
