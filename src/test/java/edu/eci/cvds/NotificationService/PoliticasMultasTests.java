package edu.eci.cvds.NotificationService;


import edu.eci.cvds.NotificationService.Model.Fines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class PoliticasMultasTests {
    private Fines fines;


    @BeforeEach

        void setUp(){
            fines = new Fines(100.0 ,5.0, 3);
        }


    @Test
    void contextLoads() {
        assertNotNull(fines);
    }

    @Test
    void testGetters() {
        assertEquals(100.0, fines.getMontoBase());
        assertEquals(5.0, fines.getTarifaPorDia());
        assertEquals(3, fines.getDiasDeGracia());
    }
    
    @Test
    void testSetters() {
        fines.setMontoBase(150.0);
        fines.setTarifaPorDia(10.0);
        fines.setDiasDeGracia(5);

        assertEquals(150.0, fines.getMontoBase());
        assertEquals(10.0, fines.getTarifaPorDia());
        assertEquals(5, fines.getDiasDeGracia());
    }

    @Test
    void testCalcularMultaSinRetraso() {
        double multa = fines.calcularMulta(2);
        assertEquals(0.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoDentroDeGracia() {
        double multa = fines.calcularMulta(3);
        assertEquals(0.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoFueraDeGracia() {
        double multa = fines.calcularMulta(5);
        assertEquals(110.0, multa);
    }

    @Test
    void testCalcularMultaConRetrasoSignificativo() {
        double multa = fines.calcularMulta(10);
        assertEquals(135.0, multa);
    }

    @Test
    void testConstructorSinId() {
        Fines nuevaPolitica = new Fines(200.0, 15.0, 7);
        assertEquals(200.0, nuevaPolitica.getMontoBase());
        assertEquals(15.0, nuevaPolitica.getTarifaPorDia());
        assertEquals(7, nuevaPolitica.getDiasDeGracia());
        assertNull(nuevaPolitica.getId());
    }

}
