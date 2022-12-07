package com.emergente.dao;

import com.emergente.modelo.Marca;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAOimpl extends ConexionDB implements MarcaDAO {

    @Override
    public void insert(Marca marca) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO marcas(nombre) VALUES(?)");
            ps.setString(1, marca.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Marca marca) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE marcas SET nombre=? WHERE id_marcas=?");
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId_marcas());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from marcas WHERE id_marcas = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Marca getById(int id) throws Exception {
        Marca marc = new Marca();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM marcas WHERE id_marcas = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                marc.setId_marcas(rs.getInt("id_marcas"));
                marc.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return marc;
    }

    @Override
    public List<Marca> getAll() throws Exception {
        List<Marca> lista = null;
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM marcas");

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Marca>();

            while (rs.next()) {
                Marca marc = new Marca();
                marc.setId_marcas(rs.getInt("id_marcas"));
                marc.setNombre(rs.getString("nombre"));

                lista.add(marc);
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
