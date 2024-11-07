package com.example.GestionNotificaciones.entity;

//Primero

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

@Document
public class Estudiante{
    
    @Id 
    private String id;
    
    private String nombre;
    private String apellido;
    private String codigo;

    public Estudiante() {}

    public Estudiante(String nombre, String apellido, String codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}