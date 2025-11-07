package com.wvl.negocio.entidades;

public class Persona {
  protected String nombres;
  protected String primerApellido;
  protected String segundoApellido;
  protected String dni;
  String nombresCompletos() {
    return nombres + " " + primerApellido + " " + segundoApellido;
  }
}
