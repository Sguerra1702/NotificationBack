package edu.eci.cvds.NotificationService.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import edu.eci.cvds.NotificationService.Repository.IEmailRepository;
import edu.eci.cvds.NotificationService.Model.EmailDTO;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailNotificationService  implements IEmailRepository{

    
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailNotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
    }
    

    @Override
    public void enviarCorreo(EmailDTO emailDto) throws MessagingException{
        try {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(emailDto.getResponsableEconomico());
        helper.setSubject(emailDto.getAsunto());
        helper.setText(emailDto.getMensaje(), true);
        javaMailSender.send(message);
    } catch (Exception e){
        throw new RuntimeException("Error al enviar el correo electronico:" + e.getMessage(), e);
    }
    }
}
