
package com.emergente.modelo;

public class Producto_talla {
    private int id_producto_talla;
    private int id_producto;
    private int id_talla;
    private String producto;
    private String talla;

    public Producto_talla() {
    }

    public int getId_producto_talla() {
        return id_producto_talla;
    }

    public void setId_producto_talla(int id_producto_talla) {
        this.id_producto_talla = id_producto_talla;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_talla() {
        return id_talla;
    }

    public void setId_talla(int id_talla) {
        this.id_talla = id_talla;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Producto_talla{" + "id_producto_talla=" + id_producto_talla + ", id_producto=" + id_producto + ", id_talla=" + id_talla + ", producto=" + producto + ", talla=" + talla + '}';
    }
    
    
}
