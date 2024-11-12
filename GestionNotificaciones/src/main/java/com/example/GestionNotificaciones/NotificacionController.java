package com.example.GestionNotificaciones;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Notification REST controller
 */
@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/enviarCorreo")
    public String enviarCorreo(@RequestBody Map<String, String> request) {
        String destinatario = request.get("destinatario");
        String asunto = request.get("asunto");
        String mensaje = request.get("mensaje");
        
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(destinatario);
            email.setSubject(asunto);
            email.setText(mensaje);
            email.setFrom("paula.paez@mail.escuelaing.edu.co");

            mailSender.send(email);
            return "Correo enviado exitosamente!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al enviar el correo: " + e.getMessage();
        }
    }
}
