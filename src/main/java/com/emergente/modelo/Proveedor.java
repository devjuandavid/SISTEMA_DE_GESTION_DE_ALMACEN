
package com.emergente.modelo;

public class Proveedor {
    private int id_proveedores;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String correo;
    private String observaciones;

    public Proveedor() {
    }

    public int getId_proveedores() {
        return id_proveedores;
    }

    public void setId_proveedores(int id_proveedores) {
        this.id_proveedores = id_proveedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedores=" + id_proveedores + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono + ", correo=" + correo + ", observaciones=" + observaciones + '}';
    }
    
    
}
