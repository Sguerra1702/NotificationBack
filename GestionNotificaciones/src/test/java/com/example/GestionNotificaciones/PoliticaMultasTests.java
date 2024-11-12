package com.example.GestionNotificaciones;

import com.example.GestionNotificaciones.entity.PoliticaMultas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PoliticaMultasTests {

    private PoliticaMultas politicaMultas;

    @BeforeEach
    void setUp() {
        politicaMultas = new PoliticaMultas(100.0, 5.0, 3);
    }

    @Test
    void contextLoads() {
        assertNotNull(politicaMultas);
    }

    @Test
    void testGetters() {
        assertEquals(100.0, politicaMultas.getMontoBase());
        assertEquals(5.0, politicaMultas.getTarifaPorDia());
        assertEquals(3, politicaMultas.getDiasDeGracia());
    }

    @Test
    void testSetters() {
        politicaMultas.setMontoBase(150.0);
        politicaMultas.setTarifaPorDia(10.0);
        politicaMultas.setDiasDeGracia(5);

        assertEquals(150.0, politicaMultas.getMontoBase());
        assertEquals(10.0, politicaMultas.getTarifaPorDia());
        assertEquals(5, politicaMultas.getDiasDeGracia());
    }

    @Test
    void testCalcularMultaSinRetraso() {
        double multa = politicaMultas.calcularMulta(2);
        assertEquals(0.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoDentroDeGracia() {
        double multa = politicaMultas.calcularMulta(3);
        assertEquals(0.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoFueraDeGracia() {
        double multa = politicaMultas.calcularMulta(5);
        assertEquals(110.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoSignificativo() {
        double multa = politicaMultas.calcularMulta(10);
        assertEquals(135.0, multa);
    }

    @Test
    void testConstructorSinId() {
        PoliticaMultas nuevaPolitica = new PoliticaMultas(200.0, 15.0, 7);
        assertEquals(200.0, nuevaPolitica.getMontoBase());
        assertEquals(15.0, nuevaPolitica.getTarifaPorDia());
        assertEquals(7, nuevaPolitica.getDiasDeGracia());
        assertNull(nuevaPolitica.getId());
    }
}

