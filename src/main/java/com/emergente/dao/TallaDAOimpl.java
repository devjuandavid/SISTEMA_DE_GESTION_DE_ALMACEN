package com.emergente.dao;

import com.emergente.modelo.Talla;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TallaDAOimpl extends ConexionDB implements TallaDAO {

    @Override
    public void insert(Talla talla) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO tallas(medida) VALUES(?)");
            ps.setString(1, talla.getMedida());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Talla talla) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE tallas SET medida=? WHERE id_talla=?");
            ps.setString(1, talla.getMedida());
            ps.setInt(2, talla.getId_talla());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from tallas WHERE id_talla = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Talla getById(int id) throws Exception {
        Talla tal = new Talla();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM tallas WHERE id_talla = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tal.setId_talla(rs.getInt("id_talla"));
                tal.setMedida(rs.getString("medida"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return tal;
    }

    @Override
    public List<Talla> getAll() throws Exception {
        List<Talla> lista = null;
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM tallas");

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Talla>();

            while (rs.next()) {
                Talla tal = new Talla();
                tal.setId_talla(rs.getInt("id_talla"));
                tal.setMedida(rs.getString("medida"));

                lista.add(tal);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
