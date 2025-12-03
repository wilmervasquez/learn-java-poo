package com.wvl.stage4.models;

import java.time.LocalDateTime;

public class Venta {
  private int id;
  private int productoId;
  private int empleadoId;
  private int cantidad;
  private double precioUnitario;
  private LocalDateTime fechaVenta;

  public Venta() {}

  public Venta(int id, int productoId, int empleadoId, int cantidad, double precioUnitario, LocalDateTime fechaVenta) {
    this.id = id;
    this.productoId = productoId;
    this.empleadoId = empleadoId;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.fechaVenta = fechaVenta;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductoId() {
    return productoId;
  }

  public void setProductoId(int productoId) {
    this.productoId = productoId;
  }

  public int getEmpleadoId() {
    return empleadoId;
  }

  public void setEmpleadoId(int empleadoId) {
    this.empleadoId = empleadoId;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecioUnitario() {
    return precioUnitario;
  }

  public void setPrecioUnitario(double precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public LocalDateTime getFechaVenta() {
    return fechaVenta;
  }

  public void setFechaVenta(LocalDateTime fechaVenta) {
    this.fechaVenta = fechaVenta;
  }
}