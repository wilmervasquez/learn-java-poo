package com.wvl.ef.models;

import java.util.Objects;

public class Pelicula {
  private int id;
  private String codigo;
  private String titulo;
  private String genero;
  private Integer duracion; 

  public Pelicula() {}
  public Pelicula(int id, String codigo, String titulo, String genero, Integer duracion) {
    this.id = id; this.codigo = codigo; this.titulo = titulo; this.genero = genero; this.duracion = duracion;
  }
  public Pelicula(String codigo, String titulo, String genero, Integer duracion) {
    this(0, codigo, titulo, genero, duracion);
  }

  // getters & setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getCodigo() { return codigo; }
  public void setCodigo(String codigo) { this.codigo = codigo; }
  public String getTitulo() { return titulo; }
  public void setTitulo(String titulo) { this.titulo = titulo; }
  public String getGenero() { return genero; }
  public void setGenero(String genero) { this.genero = genero; }
  public Integer getDuracion() { return duracion; }
  public void setDuracion(Integer duracion) { this.duracion = duracion; }

  @Override
  public String toString() {
    return titulo + " " + genero;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pelicula)) return false;
    Pelicula pelicula = (Pelicula) o;
    return id == pelicula.id;
  }
  @Override
  public int hashCode() { return Objects.hash(id); }
}
