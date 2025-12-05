package com.wvl.stage4.models;

import java.time.LocalDate;

public class Empleado extends  Persona {
  private int id;
  private String telefono;
  private String cargo;
  private LocalDate fechaContratacion;

  public Empleado(int id, String nombre, String apellido, String dni, String telefono, String cargo, LocalDate fechaContratacion) {
    super(nombre, apellido, dni);
    this.id = id;
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