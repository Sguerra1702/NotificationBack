package com.example.GestionNotificaciones.service;

import org.thymeleaf.context.Context;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.GestionNotificaciones.models.EmailDTO;
import com.example.GestionNotificaciones.repository.IEmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImp implements IEmailService{
    
    private final JavaMailSender javaMailSender;
    private final TemplateLateEngine templateLateEngine;

    public EmailServiceImp(JavaMailSender javaMailSender, TemplateLateEngine templateLateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateLateEngine = templateLateEngine;
    }

    @Override
    public void enviarCorreo(EmailDTO emailDto) throws MessagingException{
        try {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(emailDto.getResponsableEconomico());
        helper.setSubject(emailDto.getAsunto());

        helper.setText(emailDto.getMensaje());
        Context context = new Context();
        context.setVariable("message", emailDto.getMensaje());
        String contentHTML = templateLateEngine.process("email", context);

        helper.setText(contentHTML, true);
        javaMailSender.send(message);
    } catch (Exception e){
        throw new RuntimeException("Error al enviar el correo electronico:" + e.getMessage(), e);
    }
    }
}
