package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.EmailDTO;
import edu.eci.cvds.NotificationService.Service.EmailNotificationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.mail.MessagingException;


@SpringBootTest
public class EmailNotificationServiceTest {


    @Autowired
    private EmailNotificationService emailNotificationService;  // El servicio de correo

    
    @Test
    public void testEnviarCorreo() throws MessagingException {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setResponsableEconomico("NataliaPaez993@gmail.com");  // Dirección de correo de prueba
        emailDTO.setAsunto("Funciona");
        emailDTO.setMensaje("Me debes esta vida y la otra");

        emailNotificationService.enviarCorreo(emailDTO);

    }
}