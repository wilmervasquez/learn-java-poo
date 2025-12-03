package com.wvl.stage4.models;

import java.time.LocalDate;

public class Empleado {
  private int id;
  private String nombre;
  private String apellido;
  private String dni;
  private String telefono;
  private String cargo;
  private LocalDate fechaContratacion;

  public Empleado() {}

  public Empleado(int id, String nombre, String apellido, String dni, String telefono, String cargo, LocalDate fechaContratacion) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.telefono = telefono;
    this.cargo = cargo;
    this.fechaContratacion = fechaContratacion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public LocalDate getFechaContratacion() {
    return fechaContratacion;
  }

  public void setFechaContratacion(LocalDate fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
  }
}