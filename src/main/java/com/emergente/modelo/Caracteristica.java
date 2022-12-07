package com.emergente.modelo;

public class Caracteristica {

    private int id_caracteristica;
    private String tipo;

    public Caracteristica() {
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

    @Override
    public String toString() {
        return "Caracteristica{" + "id_caracteristica=" + id_caracteristica + ", tipo=" + tipo + '}';
    }

}
