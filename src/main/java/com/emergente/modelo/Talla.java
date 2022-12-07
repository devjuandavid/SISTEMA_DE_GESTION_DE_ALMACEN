package com.emergente.modelo;

public class Talla {

    private int id_talla;
    private String medida;

    public Talla() {
    }

    public int getId_talla() {
        return id_talla;
    }

    public void setId_talla(int id_talla) {
        this.id_talla = id_talla;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        return "Talla{" + "id_talla=" + id_talla + ", medida=" + medida + '}';
    }

}
