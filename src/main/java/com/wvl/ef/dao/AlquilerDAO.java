package com.wvl.ef.dao;

import com.wvl.ef.database.ConexionDB;
import com.wvl.ef.models.Alquiler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO {
    // CREATE
    public Alquiler create(Alquiler a) {
        String sql = "INSERT INTO alquileres (cliente_id, pelicula_id, fecha_alquiler, fecha_devolucion, precio, estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, a.getClienteId());
            ps.setInt(2, a.getPeliculaId());
            ps.setDate(3, Date.valueOf(a.getFechaAlquiler()));
            if (a.getFechaDevolucion() != null) ps.setDate(4, Date.valueOf(a.getFechaDevolucion()));
            else ps.setNull(4, Types.DATE);
            ps.setDouble(5, a.getPrecio());
            ps.setString(6, a.getEstado());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) a.setId(rs.getInt(1));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // READ by id
    public Alquiler findById(int id) {
        String sql = "SELECT * FROM alquileres WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRowToAlquiler(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ all
    public List<Alquiler> findAll() {
        List<Alquiler> list = new ArrayList<>();
        String sql = "SELECT * FROM alquileres";
        try (Connection conn = ConexionDB.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRowToAlquiler(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    public boolean update(Alquiler a) {
        String sql = "UPDATE alquileres SET cliente_id = ?, pelicula_id = ?, fecha_alquiler = ?, fecha_devolucion = ?, precio = ?, estado = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, a.getClienteId());
            ps.setInt(2, a.getPeliculaId());
            ps.setDate(3, Date.valueOf(a.getFechaAlquiler()));
            if (a.getFechaDevolucion() != null) ps.setDate(4, Date.valueOf(a.getFechaDevolucion()));
            else ps.setNull(4, Types.DATE);
            ps.setDouble(5, a.getPrecio());
            ps.setString(6, a.getEstado());
            ps.setInt(7, a.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM alquileres WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Alquiler mapRowToAlquiler(ResultSet rs) throws SQLException {
        Alquiler a = new Alquiler();
        a.setId(rs.getInt("id"));
        a.setClienteId(rs.getInt("cliente_id"));
        a.setPeliculaId(rs.getInt("pelicula_id"));

        Date sqlFechaAlq = rs.getDate("fecha_alquiler");
        if (sqlFechaAlq != null) a.setFechaAlquiler(sqlFechaAlq.toLocalDate());

        Date sqlFechaDev = rs.getDate("fecha_devolucion");
        if (sqlFechaDev != null) a.setFechaDevolucion(sqlFechaDev.toLocalDate());

        a.setPrecio(rs.getDouble("precio"));
        a.setEstado(rs.getString("estado"));
        return a;
    }
}

