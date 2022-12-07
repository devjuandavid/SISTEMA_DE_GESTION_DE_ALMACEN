package com.emergente.dao;

import com.emergente.modelo.Tipo;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDAOimpl extends ConexionDB implements TipoDAO {

    @Override
    public void insert(Tipo tipo) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO tipos (nombre,detalle,id_proveedores,id_compras) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tipo.getNombre());
            ps.setString(2, tipo.getDetalle());
            ps.setInt(3, tipo.getId_proveedores());
            ps.setInt(4, tipo.getId_compras());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Tipo tipo) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE tipos SET nombre=?,detalle=?,id_proveedores=?,id_compras=? WHERE id_tipo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, tipo.getNombre());
            ps.setString(2, tipo.getDetalle());
            ps.setInt(3, tipo.getId_proveedores());
            ps.setInt(4, tipo.getId_compras());
            ps.setInt(5, tipo.getId_tipo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {

            this.conectar();
            String sql = "DELETE FROM tipos WHERE id_tipo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Tipo getById(int id) throws Exception {
        Tipo tip = new Tipo();
        try {

            this.conectar();
            String sql = "SELECT * FROM tipos WHERE id_tipo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tip.setId_tipo(rs.getInt("id_tipo"));
                tip.setNombre(rs.getString("nombre"));
                tip.setDetalle(rs.getString("detalle"));
                tip.setId_proveedores(rs.getInt("id_proveedores"));
                tip.setId_compras(rs.getInt("id_compras"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return tip;
    }

    @Override
    public List<Tipo> getAll() throws Exception {
        List<Tipo> lista = null;
        try {

            this.conectar();
            String sql = "SELECT tip.*,p.nombre AS proveedores,c.descripcion AS compras FROM tipos tip ";
            sql += "LEFT JOIN proveedores p ON tip.id_proveedores = p.id_proveedores ";
            sql += "LEFT JOIN compras c ON tip.id_compras= c.id_compras;";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Tipo>();

            while (rs.next()) {
                Tipo tip = new Tipo();
                tip.setId_tipo(rs.getInt("id_tipo"));
                tip.setNombre(rs.getString("nombre"));
                tip.setDetalle(rs.getString("detalle"));
                tip.setId_proveedores(rs.getInt("id_proveedores"));
                tip.setId_compras(rs.getInt("id_compras"));
                tip.setProveedores(rs.getString("proveedores"));
                tip.setCompras(rs.getString("compras"));
                lista.add(tip);

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
