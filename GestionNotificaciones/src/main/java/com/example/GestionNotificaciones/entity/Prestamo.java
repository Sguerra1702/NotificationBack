package com.example.GestionNotificaciones.entity;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;

@Document(collection = "prestamos")
public class Prestamo {

    @Id
    private String id;

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean vencido;
    private String libroId;
    private ResponsableEconomico responsableEconomico;

    public Prestamo(){}

    public Prestamo(ResponsableEconomico responsableEconomico, LocalDate fechaPrestamo, LocalDate fechaDevolucion, boolean vencido, String libroId){
        this.responsableEconomico = responsableEconomico;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.vencido = vencido;
        this.libroId = libroId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResponsableEconomico getResponsableEconomico() {
        return responsableEconomico;
    }

    public void setResponsableEconomico(ResponsableEconomico responsableEconomico) {
        this.responsableEconomico = responsableEconomico;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isVencido() {
        return vencido;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
}