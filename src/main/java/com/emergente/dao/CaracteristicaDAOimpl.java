package com.emergente.dao;

import com.emergente.modelo.Caracteristica;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaracteristicaDAOimpl extends ConexionDB implements CaracteristicaDAO {

    @Override
    public void insert(Caracteristica caracteristica) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO caracteristicas (tipo) VALUES(?)");
            ps.setString(1, caracteristica.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Caracteristica caracteristica) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE caracteristicas SET tipo=? WHERE id_caracteristica=?");
            ps.setString(1, caracteristica.getTipo());
            ps.setInt(2, caracteristica.getId_caracteristica());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from caracteristicas WHERE id_caracteristica = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Caracteristica getById(int id) throws Exception {
        Caracteristica caract = new Caracteristica();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM caracteristicas WHERE id_caracteristica = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caract.setId_caracteristica(rs.getInt("id_caracteristica"));
                caract.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return caract;
    }

    @Override
    public List<Caracteristica> getAll() throws Exception {
        List<Caracteristica> lista = null;
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM caracteristicas");

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Caracteristica>();

            while (rs.next()) {
                Caracteristica caract = new Caracteristica();
                caract.setId_caracteristica(rs.getInt("id_caracteristica"));
                caract.setTipo(rs.getString("tipo"));

                lista.add(caract);
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
