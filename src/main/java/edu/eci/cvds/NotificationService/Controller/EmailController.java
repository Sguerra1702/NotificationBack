package edu.eci.cvds.NotificationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import edu.eci.cvds.NotificationService.Repository.IEmailRepository;
import edu.eci.cvds.NotificationService.Model.EmailDTO;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping
public class EmailController {

    @Autowired
    IEmailRepository emailRepository;

    @PostMapping("/send-email")
    public ResponseEntity<String> enviarCorreo(@RequestBody EmailDTO emailDTO) throws MessagingException{
        emailRepository.enviarCorreo(emailDTO);
                return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
    }
}