package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Service.EmailNotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

class EmailNotificationServiceTests {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailNotificationService emailNotificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendEmail() {
        // Definimos los parámetros del correo
        String to = "destinatario@ejemplo.com";
        String subject = "Asunto del correo";
        String text = "Contenido del correo";

        // Llamamos al método a probar
        emailNotificationService.sendEmail(to, subject, text);

        // Creamos un mensaje de correo esperado
        SimpleMailMessage expectedMessage = new SimpleMailMessage();
        expectedMessage.setTo(to);
        expectedMessage.setSubject(subject);
        expectedMessage.setText(text);

        // Verificamos que `mailSender.send` fue llamado con el mensaje correcto
        verify(mailSender, times(1)).send(refEq(expectedMessage));
    }
}

