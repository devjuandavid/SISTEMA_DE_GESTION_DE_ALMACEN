
package com.emergente.modelo;

public class Marca {
    private int id_marcas;
    private String nombre;

    public Marca() {
    }

    public int getId_marcas() {
        return id_marcas;
    }

    public void setId_marcas(int id_marcas) {
        this.id_marcas = id_marcas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" + "id_marcas=" + id_marcas + ", nombre=" + nombre + '}';
    }
    
    
    
}
