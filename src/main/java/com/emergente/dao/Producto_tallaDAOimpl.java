package com.emergente.dao;

import com.emergente.modelo.Producto_talla;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Producto_tallaDAOimpl extends ConexionDB implements Producto_tallaDAO {

    @Override
    public void insert(Producto_talla producto_talla) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO producto_tallas (id_producto,id_talla) VALUES(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, producto_talla.getId_producto());
            ps.setInt(2, producto_talla.getId_talla());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto_talla producto_talla) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE producto_tallas SET id_producto=?,id_talla=? WHERE id_producto_talla=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, producto_talla.getId_producto());
            ps.setInt(2, producto_talla.getId_talla());
            ps.setInt(3, producto_talla.getId_producto_talla());
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
            String sql = "DELETE FROM producto_tallas WHERE id_producto_talla=?";
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
    public Producto_talla getById(int id) throws Exception {
        Producto_talla protal = new Producto_talla();
        try {

            this.conectar();
            String sql = "SELECT * FROM producto_tallas WHERE id_producto_talla=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                protal.setId_producto_talla(rs.getInt("id_producto_talla"));
                protal.setId_producto(rs.getInt("id_producto"));
                protal.setId_talla(rs.getInt("id_talla"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return protal;
    }

    @Override
    public List<Producto_talla> getAll() throws Exception {
        List<Producto_talla> lista = null;
        try {

            this.conectar();
            String sql = "SELECT protal.*,p.nombre AS producto,t.medida AS talla FROM producto_tallas protal ";
            sql += "LEFT JOIN productos p ON protal.id_producto = p.id_producto ";
            sql += "LEFT JOIN tallas t ON protal.id_talla= t.id_talla;";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Producto_talla>();

            while (rs.next()) {
                Producto_talla protal = new Producto_talla();
                protal.setId_producto_talla(rs.getInt("id_producto_talla"));
                protal.setId_producto(rs.getInt("id_producto"));
                protal.setId_talla(rs.getInt("id_talla"));
                protal.setProducto(rs.getString("producto"));
                protal.setTalla(rs.getString("talla"));
                lista.add(protal);

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
