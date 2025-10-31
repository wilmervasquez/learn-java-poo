package com.wvl.negocio.entidades;

import java.time.LocalDate;
import java.util.List;

public class Compra {
  private LocalDate fechaCompra;
  private Double precioTotal;
  private Integer cantidadTotal;

  private Owner owner;
  private Proveedor proveedor;
  private List<Producto> productos;
  private int cantidad;

  public LocalDate getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(LocalDate fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public Double getPrecioTotal() {
    return precioTotal;
  }

  public void setPrecioTotal(Double precioTotal) {
    this.precioTotal = precioTotal;
  }

  public Integer getCantidadTotal() {
    return cantidadTotal;
  }

  public void setCantidadTotal(Integer cantidadTotal) {
    this.cantidadTotal = cantidadTotal;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public Proveedor getProveedor() {
    return proveedor;
  }

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
