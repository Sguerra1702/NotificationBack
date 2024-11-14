package edu.eci.cvds.NotificationService.Repository;

import edu.eci.cvds.NotificationService.Model.EmailDTO;
import jakarta.mail.MessagingException;

public interface IEmailRepository {
    public void enviarCorreo(EmailDTO emailDTO) throws MessagingException;
}
