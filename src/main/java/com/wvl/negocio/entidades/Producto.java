package com.wvl.negocio.entidades;

import java.time.LocalDate;

public class Producto {
  private String codigo;
  private String nombre;
  private Double precioUnitario;
  private String descripcion;
  private String imagen;
  private int stock;
  private LocalDate fechaVencimiento;

  public Producto(String codigo, String nombre, Double precioUnitario, String descripcion, String imagen, int stock, LocalDate fechaVencimiento) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precioUnitario = precioUnitario;
    this.descripcion = descripcion;
    this.imagen = imagen;
    this.stock = stock;
    this.fechaVencimiento = fechaVencimiento;
  }


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
  public Double getPrecioUnitario() {
    return precioUnitario;
  }

  public String getCodigo() {
    return codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getImagen() {
    return imagen;
  }

  public void setPrecioUnitario(Double precioUnitario) {

  }
}
