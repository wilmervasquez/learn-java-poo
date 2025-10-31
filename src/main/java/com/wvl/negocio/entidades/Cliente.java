package com.wvl.negocio.entidades;

import java.util.List;

public class Cliente extends Persona {
  private String codigo;
  private Boolean egresado;
  private List<Venta> ventas;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Boolean getEgresado() {
    return egresado;
  }

  public void setEgresado(Boolean egresado) {
    this.egresado = egresado;
  }

  public List<Venta> getVentas() {
    return ventas;
  }

  public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
  }
}
