package com.emergente.modelo;

public class Venta_producto {

    private int id_venta_producto;
    private int id_ventas;
    private int id_producto;
    private int cantidad;
    private double descuento;
    private double precio;
    private double total;
    private String ventas;
    private String producto;

    public Venta_producto() {
    }

    public int getId_venta_producto() {
        return id_venta_producto;
    }

    public void setId_venta_producto(int id_venta_producto) {
        this.id_venta_producto = id_venta_producto;
    }

    public int getId_ventas() {
        return id_ventas;
    }

    public void setId_ventas(int id_ventas) {
        this.id_ventas = id_ventas;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Venta_producto{" + "id_venta_producto=" + id_venta_producto + ", id_ventas=" + id_ventas + ", id_producto=" + id_producto + ", cantidad=" + cantidad + ", descuento=" + descuento + ", precio=" + precio + ", total=" + total + ", ventas=" + ventas + ", producto=" + producto + '}';
    }

}
