package com.example.GestionNotificaciones;

import com.example.GestionNotificaciones.entity.Notificacion;
import com.example.GestionNotificaciones.entity.ResponsableEconomico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificacionTests {

    private Notificacion notificacion;
    private ResponsableEconomico responsable;

    @BeforeEach
    void setUp() {
        responsable = new ResponsableEconomico("Carlos", "García", "Juan Pérez", "carlos@example.com");
        notificacion = new Notificacion("Pago", "Tu pago ha sido procesado", LocalDate.now(), responsable);
    }

    @Test
    void contextLoads() {
        assertNotNull(notificacion);
    }

    @Test
    void testGetters() {
        assertEquals("Pago", notificacion.getTipo());
        assertEquals("Tu pago ha sido procesado", notificacion.getMensaje());
        assertEquals(LocalDate.now(), notificacion.getFechaEnvio());
        assertEquals("Carlos", notificacion.getResponsableEconomico().getNombre());
        assertEquals("García", notificacion.getResponsableEconomico().getApellido());
        assertEquals("Juan Pérez", notificacion.getResponsableEconomico().getEstudiante());
        assertEquals("carlos@example.com", notificacion.getResponsableEconomico().getEmail());
    }

    @Test
    void testSetters() {
        notificacion.setTipo("Aviso");
        notificacion.setMensaje("Por favor, revisa tu estado de cuenta");
        notificacion.setFechaEnvio(LocalDate.of(2024, 11, 12));

        ResponsableEconomico nuevoResponsable = new ResponsableEconomico("Ana", "Lopez", "Pedro López", "ana@example.com");
        notificacion.setResponsableEconomico(nuevoResponsable);

        assertEquals("Aviso", notificacion.getTipo());
        assertEquals("Por favor, revisa tu estado de cuenta", notificacion.getMensaje());
        assertEquals(LocalDate.of(2024, 11, 12), notificacion.getFechaEnvio());
        assertEquals("Ana", notificacion.getResponsableEconomico().getNombre());
        assertEquals("Lopez", notificacion.getResponsableEconomico().getApellido());
        assertEquals("Pedro López", notificacion.getResponsableEconomico().getEstudiante());
        assertEquals("ana@example.com", notificacion.getResponsableEconomico().getEmail());
    }

    @Test
    void testConstructorWithoutId() {
        Notificacion nuevaNotificacion = new Notificacion("Recordatorio", "Pago pendiente", LocalDate.of(2024, 12, 15), responsable);
        assertEquals("Recordatorio", nuevaNotificacion.getTipo());
        assertEquals("Pago pendiente", nuevaNotificacion.getMensaje());
        assertEquals(LocalDate.of(2024, 12, 15), nuevaNotificacion.getFechaEnvio());
        assertNull(nuevaNotificacion.getId());
        assertEquals("Carlos", nuevaNotificacion.getResponsableEconomico().getNombre());
        assertEquals("García", nuevaNotificacion.getResponsableEconomico().getApellido());
        assertEquals("Juan Pérez", nuevaNotificacion.getResponsableEconomico().getEstudiante());
        assertEquals("carlos@example.com", nuevaNotificacion.getResponsableEconomico().getEmail());
    }
}
