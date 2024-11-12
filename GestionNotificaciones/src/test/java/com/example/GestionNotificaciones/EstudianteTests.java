package com.example.GestionNotificaciones;

import com.example.GestionNotificaciones.entity.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteTests {

    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante("Juan", "Pérez", "A1234");
    }

    @Test
    void contextLoads() {
        assertNotNull(estudiante);
    }

    @Test
    void testGetters() {
        assertEquals("Juan", estudiante.getNombre());
        assertEquals("Pérez", estudiante.getApellido());
        assertEquals("A1234", estudiante.getCodigo());
    }

    @Test
    void testSetters() {
        estudiante.setNombre("María");
        estudiante.setApellido("Gómez");
        estudiante.setCodigo("B5678");

        assertEquals("María", estudiante.getNombre());
        assertEquals("Gómez", estudiante.getApellido());
        assertEquals("B5678", estudiante.getCodigo());
    }

    @Test
    void testId() {
        estudiante.setId("12345");
        assertEquals("12345", estudiante.getId());
    }

    @Test
    void testConstructorWithoutId() {
        Estudiante nuevoEstudiante = new Estudiante("Ana", "López", "C7890");
        assertEquals("Ana", nuevoEstudiante.getNombre());
        assertEquals("López", nuevoEstudiante.getApellido());
        assertEquals("C7890", nuevoEstudiante.getCodigo());
        assertNull(nuevoEstudiante.getId());
    }
}
