package com.wvl.negocio.controlador;

import com.mysql.cj.protocol.a.LocalDateTimeValueEncoder;
import com.wvl.negocio.entidades.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductoControlador {
  private ArrayList<Producto> productos;
  public ProductoControlador() {
    productos = new ArrayList<>(List.of(
      new Producto(
        "1",
        "Tablets",
        12.90,
        "Capacidades",
        "https://i.pinimg.com/originals/91/d6/e4/91d6e46ea00132bf14fb25637d041e31.jpg",
        12,
        LocalDate.now()
      ),
      new Producto(
        "1",
        "Tablets",
        12.3,
        "Capacidades",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKD0sTWHVvNEKyLMm1pSRgg4rUQrdmoFX0Mg&s",
        12,
        LocalDate.now())
      )
    );
  }

  public ArrayList<Producto> getProductos() {
    return productos;
  }
}
