package com.emergente.modelo;

public class Tipo {

    private int id_tipo;
    private String nombre;
    private String detalle;
    private int id_proveedores;
    private int id_compras;
    private String proveedores;
    private String compras;

    public Tipo() {
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public String getProveedores() {
        return proveedores;
    }

    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }

    public String getCompras() {
        return compras;
    }

    public void setCompras(String compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Tipo{" + "id_tipo=" + id_tipo + ", nombre=" + nombre + ", detalle=" + detalle + ", id_proveedores=" + id_proveedores + ", id_compras=" + id_compras + ", proveedores=" + proveedores + ", compras=" + compras + '}';
    }

}
