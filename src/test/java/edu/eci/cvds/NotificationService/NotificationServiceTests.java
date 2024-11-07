package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Service.EmailNotificationService;
import edu.eci.cvds.NotificationService.Service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class NotificationServiceTests {

    @Mock
    private EmailNotificationService emailNotificationService;

    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendLoanMadeNotification() {
        LocalDateTime time = LocalDateTime.now();
        notificationService.sendNotification(1, NotificationType.LOAN_MADE, time, 1001, 2002, 3003, "Active", 0);

        verify(emailNotificationService, times(1)).sendEmail(
                eq("rodriguezandres160918@gmail.com"),
                eq("PRESTAMO REALIZADO"),
                eq("prestamo realizado, fecha limite de devolucion" + time)
        );
    }

    @Test
    void testSendLoanReminderNotification() {
        notificationService.sendNotification(2, NotificationType.LOAN_REMINDER, LocalDateTime.now(), 1002, 2003, 3004, "Active", 0);

        verify(emailNotificationService, times(1)).sendEmail(
                eq("rodriguezandres160918@gmail.com"),
                eq("RECORDATORIO DE PRESTAMO"),
                eq("el recordatorio vence en 3 dias ")
        );
    }

    @Test
    void testSendLoanOverdueNotification() {
        notificationService.sendNotification(3, NotificationType.LOAN_OVERDUE, LocalDateTime.now(), 1003, 2004, 3005, "Overdue", 0);

        verify(emailNotificationService, times(1)).sendEmail(
                eq("rodriguezandres160918@gmail.com"),
                eq("PRESTAMO VENCIDO"),
                eq("Se vencio el prestamo, devuelva el libro")
        );
    }

    @Test
    void testSendFineNotification() {
        notificationService.sendNotification(4, NotificationType.FINE, LocalDateTime.now(), 1004, 2005, 3006, "Active", 50.0);

        verify(emailNotificationService, times(1)).sendEmail(
                eq("rodriguezandres160918@gmail.com"),
                eq("NOTIFICACION DE MULTA"),
                eq("Notificacion de multa, debe pagar" + 50.0)
        );
    }
}

