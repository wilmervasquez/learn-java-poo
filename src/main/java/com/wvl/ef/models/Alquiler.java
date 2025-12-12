package com.wvl.ef.models;

// Alquiler.java
import java.time.LocalDate;
import java.util.Objects;

public class Alquiler {
    private int id;
    private int clienteId;
    private int peliculaId;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion; // nullable
    private double precio;
    private String estado;

    public Alquiler() {}
    public Alquiler(int id, int clienteId, int peliculaId, LocalDate fechaAlquiler,
                    LocalDate fechaDevolucion, double precio, String estado) {
        this.id = id; this.clienteId = clienteId; this.peliculaId = peliculaId;
        this.fechaAlquiler = fechaAlquiler; this.fechaDevolucion = fechaDevolucion;
        this.precio = precio; this.estado = estado;
    }
    public Alquiler(int clienteId, int peliculaId, LocalDate fechaAlquiler,
                    LocalDate fechaDevolucion, double precio, String estado) {
        this(0, clienteId, peliculaId, fechaAlquiler, fechaDevolucion, precio, estado);
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    public int getPeliculaId() { return peliculaId; }
    public void setPeliculaId(int peliculaId) { this.peliculaId = peliculaId; }
    public LocalDate getFechaAlquiler() { return fechaAlquiler; }
    public void setFechaAlquiler(LocalDate fechaAlquiler) { this.fechaAlquiler = fechaAlquiler; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", clienteId=" + clienteId + ", peliculaId=" + peliculaId +
                ", fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion +
                ", precio=" + precio + ", estado='" + estado + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alquiler)) return false;
        Alquiler alquiler = (Alquiler) o;
        return id == alquiler.id;
    }
    @Override
    public int hashCode() { return Objects.hash(id); }
}
