package edu.eci.cvds.NotificationService.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fines")
public class Fines {

    @Id
    private String id;

    private double montoBase;           
    private double tarifaPorDia;         
    private int diasDeGracia;           


    public Fines() {}

    public Fines(double montoBase, double tarifaPorDia, int diasDeGracia) {
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
            return 0.0;  
        }
        return montoBase + (diasDeRetraso - diasDeGracia) * tarifaPorDia;
    }
}
