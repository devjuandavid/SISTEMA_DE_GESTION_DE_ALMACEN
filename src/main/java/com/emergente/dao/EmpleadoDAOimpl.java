package com.emergente.dao;

import com.emergente.modelo.Empleado;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOimpl extends ConexionDB implements EmpleadoDAO {

    @Override
    public void insert(Empleado empleado) throws Exception {
        try {

            this.conectar();
            String sql = "INSERT INTO empleados (ci,nombre,apellidos,direccion,numero,telefono,id_usuario) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getCi());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getDireccion());
            ps.setString(5, empleado.getNumero());
            ps.setString(6, empleado.getTelefono());
            ps.setInt(7, empleado.getId_usuario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Empleado empleado) throws Exception {
        try {

            this.conectar();
            String sql = "UPDATE empleados SET ci=?,nombre=?,apellidos=?,direccion=?,numero=?,telefono=?,id_usuario=? WHERE id_empleados=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getCi());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getDireccion());
            ps.setString(5, empleado.getNumero());
            ps.setString(6, empleado.getTelefono());
            ps.setInt(7, empleado.getId_usuario());
            ps.setInt(8, empleado.getId_empleados());
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
            String sql = "DELETE FROM empleados WHERE id_empleados=?";
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
    public Empleado getById(int id) throws Exception {
        Empleado empl = new Empleado();
        try {

            this.conectar();
            String sql = "SELECT * FROM empleados WHERE id_empleados=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empl.setId_empleados(rs.getInt("id_empleados"));
                empl.setCi(rs.getString("ci"));
                empl.setNombre(rs.getString("nombre"));
                empl.setApellidos(rs.getString("apellidos"));
                empl.setDireccion(rs.getString("direccion"));
                empl.setNumero(rs.getString("numero"));
                empl.setTelefono(rs.getString("telefono"));
                empl.setId_usuario(rs.getInt("id_usuario"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return empl;
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        List<Empleado> lista = null;
        try {

            this.conectar();
            String sql = "SELECT empl.*,u.usuario AS usuario FROM empleados empl ";
            sql += "LEFT JOIN usuarios u ON empl.id_usuario = u.id_usuario; ";

            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Empleado>();

            while (rs.next()) {
                Empleado empl = new Empleado();
                empl.setId_empleados(rs.getInt("id_empleados"));
                empl.setCi(rs.getString("ci"));
                empl.setNombre(rs.getString("nombre"));
                empl.setApellidos(rs.getString("apellidos"));
                empl.setDireccion(rs.getString("direccion"));
                empl.setNumero(rs.getString("numero"));
                empl.setTelefono(rs.getString("telefono"));
                empl.setId_usuario(rs.getInt("id_usuario"));
                empl.setUsuario(rs.getString("usuario"));
                lista.add(empl);

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
