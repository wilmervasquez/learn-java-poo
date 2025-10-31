package com.wvl.negocio.entidades;

import java.time.LocalDate;

public class Producto {
  private String codigo;
  private String nombre;
  private Double precioUnitario;
  private String descripcion;
  private int stock;
  private LocalDate fechaVencimiento;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public LocalDate getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(LocalDate fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }
}
