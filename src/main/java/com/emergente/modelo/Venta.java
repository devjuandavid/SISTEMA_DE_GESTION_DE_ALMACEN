package com.emergente.modelo;

import java.sql.Date;

public class Venta {

    private int id_ventas;
    private String cliente;
    private String descripcion;
    private Date fecha;
    private int id_usuario;
    private String usuario;

    public Venta() {
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_ventas=" + id_ventas + ", cliente=" + cliente + ", descripcion=" + descripcion + ", fecha=" + fecha + ", id_usuario=" + id_usuario + ", usuario=" + usuario + '}';
    }

}
