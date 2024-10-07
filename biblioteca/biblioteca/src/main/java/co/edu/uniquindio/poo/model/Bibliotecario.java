package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Bibliotecario extends Persona{

    private double salario;
    private LocalDate fechaContratacion;


    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario, LocalDate fechaContratacion){
        super(nombre, id, telefono, correo);
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
    }



    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }



    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }



    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    

}
