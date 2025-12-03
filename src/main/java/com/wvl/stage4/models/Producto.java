package com.wvl.stage4.models;

public class Producto {

  private int id;
  private String sku;
  private String nombre;
  private String marca;
  private double precio;
  private int cantidad;
  private int categoriaId;
  private int activo;
  private Categoria categoria;

  public Producto() {}

  public Producto(int id, String sku, String nombre, String marca,
                  double precio, int cantidad, int categoriaId) {

    setId(id);
    setSku(sku);
    setNombre(nombre);
    setMarca(marca);
    setPrecio(precio);
    setCantidad(cantidad);
    setCategoriaId(categoriaId);
  }

  // --- RELACIÓN ---
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  // --- VALIDACIONES ---

  public int getId() {
    return id;
  }

  public void setId(int id) {
    if (id < 0) {
      throw new IllegalArgumentException("El ID no puede ser negativo.");
    }
    this.id = id;
  }


  // SKU
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    if (sku == null || sku.trim().isEmpty()) {
      throw new IllegalArgumentException("El SKU no puede estar vacío.");
    }
    if (sku.length() < 3) {
      throw new IllegalArgumentException("El SKU debe tener al menos 3 caracteres.");
    }
    this.sku = sku.trim();
  }


  // NOMBRE
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    validarTexto(nombre, "nombre");
    this.nombre = nombre.trim();
  }


  // MARCA
  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    validarTexto(marca, "marca");
    this.marca = marca.trim();
  }


  // PRECIO
  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    if (precio <= 0) {
      throw new IllegalArgumentException("El precio debe ser mayor a 0.");
    }
    this.precio = precio;
  }


  // CANTIDAD
  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    if (cantidad < 0) {
      throw new IllegalArgumentException("La cantidad no puede ser negativa.");
    }
    this.cantidad = cantidad;
  }


  // CATEGORÍA ID
  public int getCategoriaId() {
    return categoriaId;
  }

  public void setCategoriaId(int categoriaId) {
    if (categoriaId <= 0) {
      throw new IllegalArgumentException("Debe seleccionar una categoría válida.");
    }
    this.categoriaId = categoriaId;
  }


  // ACTIVO (0/1)
  public int getActivo() {
    return activo;
  }

  public void setActivo(int activo) {
    if (activo != 0 && activo != 1) {
      throw new IllegalArgumentException("El campo activo solo puede ser 0 o 1.");
    }
    this.activo = activo;
  }


  // --- MÉTODO AUXILIAR PARA VALIDAR CAMPOS DE TEXTO ---
  private void validarTexto(String valor, String campo) {
    if (valor == null) {
      throw new IllegalArgumentException("El " + campo + " no puede ser null.");
    }

    valor = valor.trim();

    if (valor.isEmpty()) {
      throw new IllegalArgumentException("El " + campo + " no puede estar vacío.");
    }

    if (valor.length() < 2) {
      throw new IllegalArgumentException(
      "El " + campo + " debe tener al menos 2 caracteres."
      );
    }
  }
}
