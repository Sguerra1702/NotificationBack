package edu.eci.cvds.NotificationService.Model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Loans")
public class Loan {

    @Id
    private String id;

    private LocalDate fechaLoan;
    private LocalDate fechaDevolucion;
    private boolean vencido;
    private String libroId;
    private ResponsableEconomic responsableEconomic;
    private Object isbn;

    public Loan(){}

    public Loan(ResponsableEconomic responsableEconomic, LocalDate fechaLoan, LocalDate fechaDevolucion, boolean vencido, String libroId){
        this.responsableEconomic = responsableEconomic;
        this.fechaLoan = fechaLoan;
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

    public LocalDate getFechaLoan() {
        return fechaLoan;
    }

    public void setFechaLoan(LocalDate fechaLoan) {
        this.fechaLoan = fechaLoan;
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

    public Object getIsbn() {
        return isbn;
    }

    public void SetIsbn(Object isbn){
        this.isbn=isbn;
    }

}