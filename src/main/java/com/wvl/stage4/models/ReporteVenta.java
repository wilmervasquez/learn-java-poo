package com.wvl.stage4.models;

import java.time.LocalDateTime;

public class ReporteVenta {
  private int idVenta;
  private String nombreProducto;
  private String nombreEmpleado;
  private int cantidad;
  private double precioUnitario;
  private double total;
  private LocalDateTime fecha;

  public ReporteVenta(int idVenta, String nombreProducto, String nombreEmpleado, int cantidad, double precioUnitario, LocalDateTime fecha) {
    this.idVenta = idVenta;
    this.nombreProducto = nombreProducto;
    this.nombreEmpleado = nombreEmpleado;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
    this.total = cantidad * precioUnitario;
    this.fecha = fecha;
  }

  public int getIdVenta() { return idVenta; }
  public String getNombreProducto() { return nombreProducto; }
  public String getNombreEmpleado() { return nombreEmpleado; }
  public int getCantidad() { return cantidad; }
  public double getPrecioUnitario() { return precioUnitario; }
  public double getTotal() { return total; }
  public LocalDateTime getFecha() { return fecha; }
}