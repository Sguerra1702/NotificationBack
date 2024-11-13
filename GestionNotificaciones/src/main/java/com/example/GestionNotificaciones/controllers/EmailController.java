package edu.eci.cvds.NotificationService.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionNotificaciones.models.EmailDTO;
import com.example.GestionNotificaciones.repository.IEmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping
public class EmailController {
    @Autowired
    IEmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> enviarCorreo(@RequestBody EmailDTO emailDTO) throws MessagingException{
        emailService.enviarCorreo(emailDTO);
                return new ResponseEntity<>("Correo enviado exitsamente", HttpStatus.OK);
    }
}
