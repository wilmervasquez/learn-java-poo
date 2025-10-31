package com.wvl.negocio.entidades;

import java.util.List;

public class Vendedor extends Persona {
  private String codigoEmpleado;
  private String sucursal;
  private List<Venta> ventas;
}
