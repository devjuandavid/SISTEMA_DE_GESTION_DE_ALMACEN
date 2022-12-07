package com.emergente.dao;

import com.emergente.modelo.Usuario;
import com.emergente.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO {

    @Override
    public void insert(Usuario usuario) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuarios(usuario,password) VALUES(?,?)");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuarios SET usuario=?,password=? WHERE id_usuario=?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getId_usuario());
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
            PreparedStatement ps = this.conn.prepareStatement("delete from usuarios WHERE id_usuario = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usua = new Usuario();
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios WHERE id_usuario = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usua.setId_usuario(rs.getInt("id_usuario"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usua;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {

            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuarios");

            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuario>();

            while (rs.next()) {
                Usuario usua = new Usuario();
                usua.setId_usuario(rs.getInt("id_usuario"));
                usua.setUsuario(rs.getString("usuario"));
                usua.setPassword(rs.getString("password"));

                lista.add(usua);
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
