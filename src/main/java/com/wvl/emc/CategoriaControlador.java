package com.wvl.emc;

import java.util.List;

public class CategoriaControlador {
  List<Categoria> categorias;
  void agregarCategoria(Categoria categoria) {
    categorias.add(categoria);
  }
  void listarCategorias() {
    for (Categoria categoria : categorias) {
      System.out.println(categoria.nombre);
    }
  }
}
