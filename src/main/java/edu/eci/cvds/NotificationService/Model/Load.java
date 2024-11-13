package edu.eci.cvds.NotificationService.Model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Loads")
public class Load {

    @Id
    private String id;

    private LocalDate fechaLoad;
    private LocalDate fechaDevolucion;
    private boolean vencido;
    private String libroId;
    private ResponsableEconomic responsableEconomic;

    public Load(){}

    public Load(ResponsableEconomic responsableEconomic, LocalDate fechaLoad, LocalDate fechaDevolucion, boolean vencido, String libroId){
        this.responsableEconomic = responsableEconomic;
        this.fechaLoad = fechaLoad;
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

    public ResponsableEconomic getResponsableEconomico() {
        return responsableEconomic;
    }

    public void setResponsableEconomico(ResponsableEconomic responsableEconomico) {
        this.responsableEconomic = responsableEconomico;
    }

    public String getLibroId() {
        return libroId;
    }

    public void setLibroId(String libroId) {
        this.libroId = libroId;
    }

    public LocalDate getFechaLoad() {
        return fechaLoad;
    }

    public void setFechaLoad(LocalDate fechaLoad) {
        this.fechaLoad = fechaLoad;
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