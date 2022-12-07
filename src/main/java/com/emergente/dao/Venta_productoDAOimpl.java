package com.emergente.dao;

import com.emergente.modelo.Venta_producto;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Venta_productoDAOimpl extends ConexionDB implements Venta_productoDAO {

    @Override
    public void insert(Venta_producto venta_producto) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO venta_productos (id_ventas,id_producto,cantidad,descuento,precio,total)VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta_producto.getId_ventas());
            ps.setInt(2, venta_producto.getId_producto());
            ps.setInt(3, venta_producto.getCantidad());
            ps.setDouble(4, venta_producto.getDescuento());
            ps.setDouble(5, venta_producto.getPrecio());
            ps.setDouble(6, venta_producto.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Venta_producto venta_producto) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE venta_productos SET id_ventas=?,id_producto=?,cantidad=?,descuento=?,precio=?,total=? WHERE id_venta_producto=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta_producto.getId_ventas());
            ps.setInt(2, venta_producto.getId_producto());
            ps.setInt(3, venta_producto.getCantidad());
            ps.setDouble(4, venta_producto.getDescuento());
            ps.setDouble(5, venta_producto.getPrecio());
            ps.setDouble(6, venta_producto.getTotal());
            ps.setInt(7, venta_producto.getId_venta_producto());
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
            String sql = "DELETE FROM venta_productos WHERE id_venta_producto=?";
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
    public Venta_producto getById(int id) throws Exception {
        Venta_producto venpro = new Venta_producto();
        try {

            this.conectar();
            String sql = "SELECT * FROM venta_productos WHERE id_venta_producto=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venpro.setId_venta_producto(rs.getInt("id_venta_producto"));
                venpro.setId_ventas(rs.getInt("id_ventas"));
                venpro.setId_producto(rs.getInt("id_producto"));
                venpro.setCantidad(rs.getInt("cantidad"));
                venpro.setDescuento(rs.getDouble("descuento"));
                venpro.setPrecio(rs.getDouble("precio"));
                venpro.setTotal(rs.getDouble("total"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return venpro;
    }

    @Override
    public List<Venta_producto> getAll() throws Exception {
        List<Venta_producto> lista = null;
        try {

            this.conectar();
            String sql = "SELECT venpro.*,v.cliente AS ventas,p.nombre AS producto FROM venta_productos venpro ";
            sql += "LEFT JOIN ventas v ON venpro.id_ventas = v.id_ventas ";
            sql += "LEFT JOIN productos p ON venpro.id_producto= p.id_producto;";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Venta_producto>();

            while (rs.next()) {
                Venta_producto venpro = new Venta_producto();
                venpro.setId_venta_producto(rs.getInt("id_venta_producto"));
                venpro.setId_ventas(rs.getInt("id_ventas"));
                venpro.setId_producto(rs.getInt("id_producto"));
                venpro.setCantidad(rs.getInt("cantidad"));
                venpro.setDescuento(rs.getDouble("descuento"));
                venpro.setPrecio(rs.getDouble("precio"));
                venpro.setTotal(rs.getDouble("total"));
                venpro.setVentas(rs.getString("ventas"));
                venpro.setProducto(rs.getString("producto"));
                lista.add(venpro);

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
