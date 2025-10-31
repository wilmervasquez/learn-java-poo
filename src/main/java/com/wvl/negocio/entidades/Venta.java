package com.wvl.negocio.entidades;

import java.time.LocalDate;
import java.util.List;

public class Venta {
  private LocalDate fechaVenta;
  private Integer cantidad;
  private Double total;
  private Cliente cliente;
  private Vendedor vendedor;
  private List<Producto> productos;
}
