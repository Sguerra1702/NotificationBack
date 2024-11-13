package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Model.ResponsableEconomic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class notificationnotificationTests {

    private Notification notification;
    private ResponsableEconomic responsable;

    @BeforeEach
    void setUp() {
        responsable = new ResponsableEconomic("Carlos", "García", "Juan Pérez", "carlos@example.com");
        notification = new Notification("Pago", "Tu pago ha sido procesado", LocalDate.now(), responsable);
    }

    @Test
    void contextLoads() {
        assertNotNull(notification);
    }
    /* 
    @Test
    void testGetters() {
        assertEquals("Pago", notification.getType());
        assertEquals("Tu pago ha sido procesado", notification.getmessage());
        assertEquals(LocalDate.now(), notification.getdate());
        assertEquals("Carlos", notification.getResponsableEconomic().getNombre());
        assertEquals("García", notification.getResponsableEconomic().getApellido());
        assertEquals("Juan Pérez", notification.getResponsableEconomic().getEstudiante());
        assertEquals("carlos@example.com", notification.getResponsableEconomic().getEmail());
    }

    @Test
    void testSetters() {
        notification.setType(NotificationType.LOAN_REMINDER);
        notification.setmessage("Por favor, revisa tu estado de cuenta");
        notification.setdate(LocalDate.of(2024, 11, 12));

        ResponsableEconomic nuevoResponsable = new ResponsableEconomic("Ana", "Lopez", "Pedro López", "ana@example.com");
        notification.setResponsableEconomic(nuevoResponsable);

        assertEquals("Aviso", notification.getTipo());
        assertEquals("Por favor, revisa tu estado de cuenta", notification.getmessage());
        assertEquals(LocalDate.of(2024, 11, 12), notification.getdate());
        assertEquals("Ana", notification.getResponsableEconomic().getNombre());
        assertEquals("Lopez", notification.getResponsableEconomic().getApellido());
        assertEquals("Pedro López", notification.getResponsableEconomic().getEstudiante());
        assertEquals("ana@example.com", notification.getResponsableEconomic().getEmail());
    }

    @Test
    void testConstructorWithoutId() {
        Notification nuevanotificationnotification = new Notification("Recordatorio", "Pago pendiente", LocalDate.of(2024, 12, 15), responsable);
        assertEquals("Recordatorio", nuevanotificationnotification.getTipo());
        assertEquals("Pago pendiente", nuevanotificationnotification.getmessage());
        assertEquals(LocalDate.of(2024, 12, 15), nuevanotificationnotification.getdate());
        assertNull(nuevanotificationnotification.getId());
        assertEquals("Carlos", nuevanotificationnotification.getResponsableEconomic().getNombre());
        assertEquals("García", nuevanotificationnotification.getResponsableEconomic().getApellido());
        assertEquals("Juan Pérez", nuevanotificationnotification.getResponsableEconomic().getEstudiante());
        assertEquals("carlos@example.com", nuevanotificationnotification.getResponsableEconomic().getEmail());
    }
    */
}
