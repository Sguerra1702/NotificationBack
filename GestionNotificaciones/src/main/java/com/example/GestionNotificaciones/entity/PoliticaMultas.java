package com.example.GestionNotificaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "politicas_multa")
public class PoliticaMultas {

    @Id
    private String id;

    private double montoBase;           
    private double tarifaPorDia;         
    private int diasDeGracia;           


    public PoliticaMultas() {}

    public PoliticaMultas(double montoBase, double tarifaPorDia, int diasDeGracia) {
        this.montoBase = montoBase;
        this.tarifaPorDia = tarifaPorDia;
        this.diasDeGracia = diasDeGracia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public double getTarifaPorDia() {
        return tarifaPorDia;
    }

    public void setTarifaPorDia(double tarifaPorDia) {
        this.tarifaPorDia = tarifaPorDia;
    }

    public int getDiasDeGracia() {
        return diasDeGracia;
    }

    public void setDiasDeGracia(int diasDeGracia) {
        this.diasDeGracia = diasDeGracia;
    }

    public double calcularMulta(int diasDeRetraso) {
        if (diasDeRetraso <= diasDeGracia) {
            return 0.0;  // No hay multa si el retraso está dentro del periodo de gracia
        }
        return montoBase + (diasDeRetraso - diasDeGracia) * tarifaPorDia;
    }
}
