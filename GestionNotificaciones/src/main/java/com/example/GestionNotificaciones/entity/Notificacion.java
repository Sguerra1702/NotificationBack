package com.example.GestionNotificaciones.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private String id;

    private String tipo;
    private String mensaje;
    private LocalDate fechaEnvio;
    private ResponsableEconomico responsableEconomico;

    public Notificacion() {}

    public Notificacion(String tipo, String mensaje, LocalDate fechaEnvio, ResponsableEconomico responsableEconomico) {
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.responsableEconomico = responsableEconomico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public ResponsableEconomico getResponsableEconomico() {
        return responsableEconomico;
    }

    public void setResponsableEconomico(ResponsableEconomico responsableEconomico) {
        this.responsableEconomico = responsableEconomico;
    }
}
