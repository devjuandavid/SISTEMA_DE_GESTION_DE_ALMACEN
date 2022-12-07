package com.emergente.dao;

import com.emergente.modelo.Compra;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOimpl extends ConexionDB implements CompraDAO {

    @Override
    public void insert(Compra compra) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO compras (descripcion,fecha,cantidad,precio,total,id_usuario) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, compra.getDescripcion());
            ps.setDate(2, compra.getFecha());
            ps.setDouble(3, compra.getCantidad());
            ps.setInt(4, compra.getPrecio());
            ps.setDouble(5, compra.getTotal());
            ps.setInt(6, compra.getId_usuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Compra compra) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE compras SET descripcion=?,fecha=?,cantidad=?,precio=?,total=?,id_usuario=? WHERE id_compras=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, compra.getDescripcion());
            ps.setDate(2, compra.getFecha());
            ps.setDouble(3, compra.getCantidad());
            ps.setInt(4, compra.getPrecio());
            ps.setDouble(5, compra.getTotal());
            ps.setInt(6, compra.getId_usuario());
            ps.setInt(7, compra.getId_compras());
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
            String sql = "DELETE FROM compras WHERE id_compras=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Compra getById(int id) throws Exception {
        Compra comp = new Compra();
        try {

            this.conectar();
            String sql = "SELECT * FROM compras WHERE id_compras=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comp.setId_compras(rs.getInt("id_compras"));
                comp.setDescripcion(rs.getString("descripcion"));
                comp.setFecha(rs.getDate("fecha"));
                comp.setCantidad(rs.getDouble("cantidad"));
                comp.setPrecio(rs.getInt("precio"));
                comp.setTotal(rs.getDouble("total"));
                comp.setId_usuario(rs.getInt("id_usuario"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return comp;
    }

    @Override
    public List<Compra> getAll() throws Exception {
        List<Compra> lista = null;
        try {

            this.conectar();
            String sql = "SELECT comp.*,u.usuario AS usuario FROM compras comp ";
            sql += "LEFT JOIN usuarios u ON comp.id_usuario = u.id_usuario; ";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Compra>();

            while (rs.next()) {
                Compra comp = new Compra();
                comp.setId_compras(rs.getInt("id_compras"));
                comp.setDescripcion(rs.getString("descripcion"));
                comp.setFecha(rs.getDate("fecha"));
                comp.setCantidad(rs.getDouble("cantidad"));
                comp.setPrecio(rs.getInt("precio"));
                comp.setTotal(rs.getDouble("total"));
                comp.setId_usuario(rs.getInt("id_usuario"));
                comp.setUsuario(rs.getString("usuario"));
                lista.add(comp);

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
