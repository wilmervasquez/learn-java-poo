package com.wvl.ef.dao;

import com.wvl.ef.database.ConexionDB;
import com.wvl.ef.models.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    // CREATE
    public Pelicula create(Pelicula p) {
        String sql = "INSERT INTO peliculas (codigo, titulo, genero, duracion) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getTitulo());
            ps.setString(3, p.getGenero());
            if (p.getDuracion() != null) ps.setInt(4, p.getDuracion());
            else ps.setNull(4, Types.INTEGER);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) p.setId(rs.getInt(1));
            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // READ
    public Pelicula findById(int id) {
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRowToPelicula(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Pelicula> findAll() {
        List<Pelicula> list = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";
        try (Connection conn = ConexionDB.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRowToPelicula(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE
    public boolean update(Pelicula p) {
        String sql = "UPDATE peliculas SET codigo = ?, titulo = ?, genero = ?, duracion = ? WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getTitulo());
            ps.setString(3, p.getGenero());
            if (p.getDuracion() != null) ps.setInt(4, p.getDuracion());
            else ps.setNull(4, Types.INTEGER);
            ps.setInt(5, p.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM peliculas WHERE id = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Pelicula mapRowToPelicula(ResultSet rs) throws SQLException {
        Pelicula p = new Pelicula();
        p.setId(rs.getInt("id"));
        p.setCodigo(rs.getString("codigo"));
        p.setTitulo(rs.getString("titulo"));
        p.setGenero(rs.getString("genero"));
        int dur = rs.getInt("duracion");
        if (!rs.wasNull()) p.setDuracion(dur);
        return p;
    }
}
