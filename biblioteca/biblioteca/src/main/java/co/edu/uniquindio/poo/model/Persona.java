package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Persona {

    private String nombre;
    private String id; 
    private String telefono;
    private String correo;
    private LinkedList<Prestamo> listaPrestamos;

    public Persona(String nombre, String id, String telefono, String correo){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.listaPrestamos =  new LinkedList<Prestamo>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LinkedList<Prestamo> getListaPretamos() {
        return listaPrestamos;
    }

    public void setListaPretamos(LinkedList<Prestamo> listaPretamos) {
        this.listaPrestamos = listaPretamos;
    }

}
