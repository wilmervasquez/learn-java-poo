package com.wvl.ui;

import java.util.ArrayList;
import java.util.List;

public class EstudianteController {
  private ArrayList<Estudiante> estudiantes;

  public EstudianteController() {
    this.estudiantes = new ArrayList<>();
  }

  void addEstudiante(Estudiante estudiante) {
    this.estudiantes.add(estudiante);
  }

  List<Estudiante> listarEstudiantes(){
    return estudiantes;
  }

  Estudiante buscarEstudiante(int codigo){
    for (Estudiante estudiante : this.estudiantes) {
      if (estudiante.getCodigo() == codigo) return estudiante;
    }
    return null;
  }

  void editarEstudiante(int codigo, Estudiante nuevoEstudiante){
    Estudiante estudiante = buscarEstudiante(codigo);

    if (estudiante != null){
      estudiante.setCodigo(codigo);
      estudiante.setNombres(nuevoEstudiante.getNombres());
      estudiante.setApellidos(nuevoEstudiante.getApellidos());
    }
  }

  void eliminarEstudiante(int codigo){
    Estudiante estudiante = buscarEstudiante(codigo);
    if (estudiante != null){
      estudiantes.remove(estudiante);
    }
  }
}
