package com.wvl.negocio.entidades;

import java.time.LocalDate;

public class Persona {
  protected String nombres;
  protected String primerApellido;
  protected String segundoApellido;
  protected String dni;
  String nombresCompletos() {
    return nombres + " " + primerNombre + " " + segundoNombre;
  }
}
