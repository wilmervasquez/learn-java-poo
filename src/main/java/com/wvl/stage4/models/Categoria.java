package com.wvl.stage4.models;

public class Categoria {

  private int id;
  private String nombre;

  public Categoria() {}

  public Categoria(int id, String nombre) {
    setId(id);
    setNombre(nombre);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    System.out.println(id);
    if (id < 0) {
      throw new IllegalArgumentException("El ID de la categoría no puede ser negativo.");
    }
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {

    if (nombre == null) {
      throw new IllegalArgumentException("El nombre no puede ser null.");
    }

    nombre = nombre.trim();

    // Validación: no vacío
    if (nombre.isEmpty()) {
      throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío.");
    }

    // Validación: longitud mínima
    if (nombre.length() < 3) {
      throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
    }

    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return nombre;
  }
}
