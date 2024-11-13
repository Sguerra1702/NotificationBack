package com.example.GestionNotificaciones.repository;

import com.example.GestionNotificaciones.models.EmailDTO;

import jakarta.mail.MessagingException;

public interface IEmailService {
    public void enviarCorreo(EmailDTO emailDto) throws MessagingException;
}
