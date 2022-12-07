package com.emergente.dao;

import com.emergente.modelo.Producto;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {

    @Override
    public void insert(Producto producto) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO productos (nombre,stock,id_tipo,id_marcas,id_caracteristica) VALUES(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setInt(3, producto.getId_tipo());
            ps.setInt(4, producto.getId_marcas());
            ps.setInt(5, producto.getId_caracteristica());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE productos SET nombre=?,stock=?,id_tipo=?,id_marcas=?,id_caracteristica=? WHERE id_producto=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getStock());
            ps.setInt(3, producto.getId_tipo());
            ps.setInt(4, producto.getId_marcas());
            ps.setInt(5, producto.getId_caracteristica());
            ps.setInt(6, producto.getId_producto());
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
            String sql = "DELETE FROM productos WHERE id_producto=?";
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
    public Producto getById(int id) throws Exception {
        Producto prod = new Producto();
        try {

            this.conectar();
            String sql = "SELECT * FROM productos WHERE id_producto=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prod.setId_producto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setStock(rs.getInt("stock"));
                prod.setId_tipo(rs.getInt("id_tipo"));
                prod.setId_marcas(rs.getInt("id_marcas"));
                prod.setId_caracteristica(rs.getInt("id_caracteristica"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        try {

            this.conectar();
            String sql = "SELECT prod.*,t.nombre AS tipo,m.nombre AS marcas,c.tipo AS caracteristica FROM productos prod ";
            sql += "LEFT JOIN tipos t ON prod.id_tipo = t.id_tipo ";
            sql += "LEFT JOIN marcas m ON prod.id_marcas = m.id_marcas ";
            sql += "LEFT JOIN caracteristicas c ON prod.id_caracteristica= c.id_caracteristica;";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Producto>();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre"));
                prod.setStock(rs.getInt("stock"));
                prod.setId_tipo(rs.getInt("id_tipo"));
                prod.setId_marcas(rs.getInt("id_marcas"));
                prod.setId_caracteristica(rs.getInt("id_caracteristica"));
                prod.setTipo(rs.getString("tipo"));
                prod.setMarcas(rs.getString("marcas"));
                prod.setCaracteristica(rs.getString("caracteristica"));
                lista.add(prod);

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
