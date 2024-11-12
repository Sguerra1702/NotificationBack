package com.example.GestionNotificaciones.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ResponsableEconomico{

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private String estudiante;
    private String email;

    public ResponsableEconomico(){}

    public ResponsableEconomico(String nombre, String apellido, String estudiante, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.estudiante = estudiante;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getEstudiante(){
        return estudiante;
    }

    public void setEstudiante(String estudiante){
        this.estudiante = estudiante;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}