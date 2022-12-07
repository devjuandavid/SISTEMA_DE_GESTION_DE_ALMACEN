package com.emergente.dao;

import com.emergente.modelo.Proveedor;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO {

    @Override
    public void insert(Proveedor proveedor) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO proveedores(nombre,direccion,ciudad,telefono,correo,observaciones) VALUES(?,?,?,?,?,?)");
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getCiudad());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.setString(6, proveedor.getObservaciones());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Proveedor proveedor) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE proveedores SET nombre=?,direccion=?,ciudad=?,telefono=?,correo=?,observaciones=? WHERE id_proveedores=?");
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getCiudad());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.setString(6, proveedor.getObservaciones());
            ps.setInt(7, proveedor.getId_proveedores());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from proveedores WHERE id_proveedores = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Proveedor getById(int id) throws Exception {
        Proveedor provee = new Proveedor();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores WHERE id_proveedores=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                provee.setId_proveedores(rs.getInt("id_proveedores"));
                provee.setNombre(rs.getString("nombre"));
                provee.setDireccion(rs.getString("direccion"));
                provee.setCiudad(rs.getString("ciudad"));
                provee.setTelefono(rs.getString("telefono"));
                provee.setCorreo(rs.getString("correo"));
                provee.setObservaciones(rs.getString("observaciones"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return provee;
    }

    @Override
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM proveedores");

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Proveedor>();

            while (rs.next()) {
                Proveedor provee = new Proveedor();
                provee.setId_proveedores(rs.getInt("id_proveedores"));
                provee.setNombre(rs.getString("nombre"));
                provee.setDireccion(rs.getString("direccion"));
                provee.setCiudad(rs.getString("ciudad"));
                provee.setTelefono(rs.getString("telefono"));
                provee.setCorreo(rs.getString("correo"));
                provee.setObservaciones(rs.getString("observaciones"));

                lista.add(provee);
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
