package com.emergente.modelo;

public class Empleado {

    private int id_empleados;
    private String ci;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String numero;
    private String telefono;
    private int id_usuario;
    private String usuario;

    public Empleado() {
    }

    public int getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return "Empleado{" + "id_empleados=" + id_empleados + ", ci=" + ci + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", numero=" + numero + ", telefono=" + telefono + ", id_usuario=" + id_usuario + ", usuario=" + usuario + '}';
    }

}
