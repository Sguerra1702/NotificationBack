package edu.eci.cvds.NotificationService.Model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class ResponsableEconomic{

    @Id
    private String id;

    private String nombre;
    private String apellido;
    private String estudiante;
    private String email;

    public ResponsableEconomic(){}

    public ResponsableEconomic(String nombre, String apellido, String estudiante, String email){
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        ResponsableEconomic that = (ResponsableEconomic) obj; 
        return Objects.equals(id, that.id) &&  
               Objects.equals(nombre, that.nombre) &&  
               Objects.equals(apellido, that.apellido) &&  
               Objects.equals(estudiante, that.estudiante) &&  
               Objects.equals(email, that.email);  
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, estudiante, email);  
    }
}