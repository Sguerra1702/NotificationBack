package edu.eci.cvds.NotificationService.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.NotificationService.Model.EmailDTO;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Repository.NotificationRepository;
import jakarta.mail.MessagingException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class NotificationService {
    
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailNotificationService emailNotificationService;
    @Autowired
    private TemplateEngine templateEngine;

    public void enviarNotificacionprestamorealizado(String message){

        Notification notification = new Notification();
        notification.setType(NotificationType.LOAN_MADE);
        notification.setmessage(message);
        notification.setdate(LocalDate.now());
        notificationRepository.save(notification);
    }

    public void enviarNotificacionPrestamoPorVencer(Loan loan) {
        LocalDate fechaRecordatorio = loan.getFechaDevolucion().minusDays(3);
        if (LocalDate.now().isEqual(fechaRecordatorio)) {
            Context context = new Context();
            context.setVariable("responsableNombre", loan.getResponsableEconomico().getNombre());
            context.setVariable("tituloLibro", loan.getLibroId());
            context.setVariable("id", loan.getId());
            context.setVariable("fechaLimiteDevolucion", loan.getFechaDevolucion());
            String templateName = "LoanReminder";


            String contentHTML = templateEngine.process(templateName, context);

            try {
                EmailDTO emailDto = new EmailDTO();
                emailDto.setResponsableEconomico(loan.getResponsableEconomico().getEmail());
                emailDto.setAsunto("Recordatorio: Préstamo próximo a vencer");
                emailDto.setMensaje(contentHTML);

                emailNotificationService.enviarCorreo(emailDto, "LoanReminder");

            } catch (MessagingException e) {
                throw new RuntimeException("Error al enviar notificación de préstamo por vencer: " + e.getMessage(), e);
            }
        }
    }


    public void enviarnotificacionprestamovencido(Loan loan) {
        if (LocalDate.now().isEqual(loan.getFechaDevolucion())) ;
        Context context = new Context();
        context.setVariable("responsableNombre", loan.getResponsableEconomico().getNombre());
        context.setVariable("tituloLibro", loan.getLibroId());
        context.setVariable("isbn", loan.getIsbn());
        context.setVariable("fechaPrestamo", loan.getFechaLoan());

        String templateName = "LoanOverdue";

        String contentHTML = templateEngine.process(templateName, context);

        try {
            EmailDTO emailDto = new EmailDTO();
            emailDto.setResponsableEconomico(loan.getResponsableEconomico().getEmail());
            emailDto.setAsunto("Notificación de Préstamo Vencido");
            emailDto.setMensaje(contentHTML);


            emailNotificationService.enviarCorreo(emailDto, "LoanOverdue"); // Llama al método para enviar el correo
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar notificación de préstamo vencido: " + e.getMessage(), e);
        }
        /* 
        // Crear la notificación y guardarla en el repositorio
        String message = "El préstamo ha vencido. Por favor, devuelva el libro.";
        Notification notification = new Notification("Préstamo vencido", message, LocalDate.now(), loan.getResponsableEconomico());
        notification.setType(NotificationType.LOAN_OVERDUE);
        notificationRepository.save(notification);
        */
    }




    public void enviarnotificacionmulta(String message, double multa){
        Notification notification = new Notification();
        notification.setType(NotificationType.FINE);
        notification.setmessage(message + "monto de la multa: $" + multa);
        notificationRepository.save(notification);
    }
    }

