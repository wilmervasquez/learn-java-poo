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
  private String categoria; // 🔹 Nuevo campo

  // 🔹 Constructor actualizado con categoría
  public Producto(String codigo, String nombre, Double precioUnitario, String descripcion,
                  String imagen, int stock, LocalDate fechaVencimiento, String categoria) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precioUnitario = precioUnitario;
    this.descripcion = descripcion;
    this.imagen = imagen;
    this.stock = stock;
    this.fechaVencimiento = fechaVencimiento;
    this.categoria = categoria;
  }

  // 🔹 Constructor anterior (por compatibilidad)
  public Producto(String codigo, String nombre, Double precioUnitario, String descripcion,
                  String imagen, int stock, LocalDate fechaVencimiento) {
    this(codigo, nombre, precioUnitario, descripcion, imagen, stock, fechaVencimiento, "Sin categoría");
  }

  // Getters y Setters
  public String getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getPrecioUnitario() {
    return precioUnitario;
  }

  public void setPrecioUnitario(Double precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getImagen() {
    return imagen;
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

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return String.format("%s - %s (%s) - S/%.2f", codigo, nombre, categoria, precioUnitario);
  }
}
