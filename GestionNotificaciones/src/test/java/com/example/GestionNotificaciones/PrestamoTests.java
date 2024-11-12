package com.example.GestionNotificaciones;

import com.example.GestionNotificaciones.entity.Prestamo;
import com.example.GestionNotificaciones.entity.ResponsableEconomico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrestamoTests {

    private Prestamo prestamo;
    private ResponsableEconomico responsable;

    @BeforeEach
    void setUp() {
        responsable = new ResponsableEconomico("Laura", "Martínez", "Diego Martínez", "laura@example.com");
        prestamo = new Prestamo(responsable, LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 20), false, "LIBRO123");
    }

    @Test
    void contextLoads() {
        assertNotNull(prestamo);
    }

    @Test
    void testGetters() {
        assertEquals("LIBRO123", prestamo.getLibroId());
        assertEquals(LocalDate.of(2024, 1, 10), prestamo.getFechaPrestamo());
        assertEquals(LocalDate.of(2024, 1, 20), prestamo.getFechaDevolucion());
        assertFalse(prestamo.isVencido());
        assertEquals("Laura", prestamo.getResponsableEconomico().getNombre());
        assertEquals("Martínez", prestamo.getResponsableEconomico().getApellido());
        assertEquals("Diego Martínez", prestamo.getResponsableEconomico().getEstudiante());
        assertEquals("laura@example.com", prestamo.getResponsableEconomico().getEmail());
    }

    @Test
    void testSetters() {
        prestamo.setLibroId("LIBRO456");
        prestamo.setFechaPrestamo(LocalDate.of(2024, 2, 15));
        prestamo.setFechaDevolucion(LocalDate.of(2024, 2, 25));
        prestamo.setVencido(true);

        ResponsableEconomico nuevoResponsable = new ResponsableEconomico("Miguel", "Gómez", "Ana Gómez", "miguel@example.com");
        prestamo.setResponsableEconomico(nuevoResponsable);

        assertEquals("LIBRO456", prestamo.getLibroId());
        assertEquals(LocalDate.of(2024, 2, 15), prestamo.getFechaPrestamo());
        assertEquals(LocalDate.of(2024, 2, 25), prestamo.getFechaDevolucion());
        assertTrue(prestamo.isVencido());
        assertEquals("Miguel", prestamo.getResponsableEconomico().getNombre());
        assertEquals("Gómez", prestamo.getResponsableEconomico().getApellido());
        assertEquals("Ana Gómez", prestamo.getResponsableEconomico().getEstudiante());
        assertEquals("miguel@example.com", prestamo.getResponsableEconomico().getEmail());
    }

    @Test
    void testConstructorSinId() {
        Prestamo nuevoPrestamo = new Prestamo(responsable, LocalDate.of(2024, 3, 5), LocalDate.of(2024, 3, 15), true, "LIBRO789");
        assertNull(nuevoPrestamo.getId());
        assertEquals("LIBRO789", nuevoPrestamo.getLibroId());
        assertEquals(LocalDate.of(2024, 3, 5), nuevoPrestamo.getFechaPrestamo());
        assertEquals(LocalDate.of(2024, 3, 15), nuevoPrestamo.getFechaDevolucion());
        assertTrue(nuevoPrestamo.isVencido());
        assertEquals("Laura", nuevoPrestamo.getResponsableEconomico().getNombre());
        assertEquals("Martínez", nuevoPrestamo.getResponsableEconomico().getApellido());
        assertEquals("Diego Martínez", nuevoPrestamo.getResponsableEconomico().getEstudiante());
        assertEquals("laura@example.com", nuevoPrestamo.getResponsableEconomico().getEmail());
    }

    @Test
    void testModificarEstadoVencido() {
        prestamo.setVencido(true);
        assertTrue(prestamo.isVencido());
    }

    @Test
    void testModificarFechas() {
        prestamo.setFechaPrestamo(LocalDate.of(2024, 4, 1));
        prestamo.setFechaDevolucion(LocalDate.of(2024, 4, 10));

        assertEquals(LocalDate.of(2024, 4, 1), prestamo.getFechaPrestamo());
        assertEquals(LocalDate.of(2024, 4, 10), prestamo.getFechaDevolucion());
    }
}
