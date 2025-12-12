package com.wvl.ef.models;
// Cliente.java
import java.util.Objects;

public class Cliente extends Persona {
  private int id;
  private String email;
  private String telefono;

  public Cliente() {}
  public Cliente(int id, String nombres, String apellidos, String email, String telefono) {
    super(nombres, apellidos);
    this.id = id;  
    this.email = email; 
    this.telefono = telefono;
  }
  public Cliente(String nombres, String apellidos, String email, String telefono) {
    this(0, nombres, apellidos, email, telefono);
  }

  // getters & setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getTelefono() { return telefono; }
  public void setTelefono(String telefono) { this.telefono = telefono; }

  @Override
  public String toString() {
    return nombres + " " + apellidos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cliente)) return false;
    Cliente cliente = (Cliente) o;
    return id == cliente.id;
  }
  @Override
  public int hashCode() { return Objects.hash(id); }
}
