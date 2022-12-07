package com.emergente.modelo;

import java.sql.Date;

public class Compra {

    private int id_compras;
    private String descripcion;
    private Date fecha;
    private double cantidad;
    private int precio;
    private double total;
    private int id_usuario;
    private String usuario;

    public Compra() {
    }

    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "Compra{" + "id_compras=" + id_compras + ", descripcion=" + descripcion + ", fecha=" + fecha + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + ", id_usuario=" + id_usuario + ", usuario=" + usuario + '}';
    }

  

}
