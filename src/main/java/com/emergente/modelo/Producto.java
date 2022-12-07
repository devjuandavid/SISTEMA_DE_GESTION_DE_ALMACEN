
package com.emergente.modelo;

public class Producto {
    private int id_producto;
    private String nombre;
    private int stock;
    private int id_tipo;
    private int id_marcas;
    private int id_caracteristica;
    private String tipo;
    private String marcas;
    private String caracteristica;

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_marcas() {
        return id_marcas;
    }

    public void setId_marcas(int id_marcas) {
        this.id_marcas = id_marcas;
    }

    public int getId_caracteristica() {
        return id_caracteristica;
    }

    public void setId_caracteristica(int id_caracteristica) {
        this.id_caracteristica = id_caracteristica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarcas() {
        return marcas;
    }

    public void setMarcas(String marcas) {
        this.marcas = marcas;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", stock=" + stock + ", id_tipo=" + id_tipo + ", id_marcas=" + id_marcas + ", id_caracteristica=" + id_caracteristica + ", tipo=" + tipo + ", marcas=" + marcas + ", caracteristica=" + caracteristica + '}';
    }
    
    
}
