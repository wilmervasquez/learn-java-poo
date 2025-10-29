package com.wvl.uilogin;

import java.util.ArrayList;

public class UsuarioControlador {
  ArrayList<Usuario> usuarios;
  public UsuarioControlador() {
    usuarios = new ArrayList<>();

    usuarios.add(new Usuario("Juan", "juan@gmail.com", "1234"));
  }

  public Usuario autenticar(String email, String password) {
    for (Usuario usuario : usuarios) {
      if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
        return usuario;
      }
    }
    return null;
  }
}
