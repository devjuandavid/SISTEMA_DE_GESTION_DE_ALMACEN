package com.emergente.dao;

import com.emergente.modelo.Venta;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO ventas (cliente,descripcion,fecha,id_usuario) VALUES(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setString(2, venta.getDescripcion());
            ps.setDate(3, venta.getFecha());
            ps.setInt(4, venta.getId_usuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta venta) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE ventas SET cliente=?,descripcion=?,fecha=?,id_usuario=? WHERE id_ventas=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setString(2, venta.getDescripcion());
            ps.setDate(3, venta.getFecha());
            ps.setInt(4, venta.getId_usuario());
            ps.setInt(5, venta.getId_ventas());
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
            String sql = "DELETE FROM ventas WHERE id_ventas=?";
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
    public Venta getById(int id) throws Exception {
        Venta vent = new Venta();
        try {

            this.conectar();
            String sql = "SELECT * FROM ventas WHERE id_ventas=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vent.setId_ventas(rs.getInt("id_ventas"));
                vent.setCliente(rs.getString("cliente"));
                vent.setDescripcion(rs.getString("descripcion"));
                vent.setFecha(rs.getDate("fecha"));
                vent.setId_usuario(rs.getInt("id_usuario"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return vent;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        try {

            this.conectar();
            String sql = "SELECT vent.*,u.usuario AS usuario FROM ventas vent ";
            sql += "LEFT JOIN usuarios u ON vent.id_usuario = u.id_usuario; ";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Venta>();

            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId_ventas(rs.getInt("id_ventas"));
                vent.setCliente(rs.getString("cliente"));
                vent.setDescripcion(rs.getString("descripcion"));
                vent.setFecha(rs.getDate("fecha"));
                vent.setId_usuario(rs.getInt("id_usuario"));
                vent.setUsuario(rs.getString("usuario"));
                lista.add(vent);

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
