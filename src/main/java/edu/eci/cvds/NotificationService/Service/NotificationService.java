package edu.eci.cvds.NotificationService.Service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.NotificationService.Model.EmailDTO;
import edu.eci.cvds.NotificationService.Model.Fines;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Model.Student;
import jakarta.mail.MessagingException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class NotificationService {
    
    @Autowired
    private EmailNotificationService emailNotificationService;

    @Autowired
    private TemplateEngine templateEngine;

    public void enviarNotificacionprestamorealizado(Loan loan){

        Context context = new Context();
        context.setVariable("responsableEconomico", loan.getResponsableEconomico().getNombre());
        context.setVariable("tituloLibro", loan.getLibroId());
        context.setVariable("isbn", loan.getIsbn());
        context.setVariable("fechaPrestamo", loan.getFechaLoan());
        context.setVariable("fechaLimiteDevolucion", loan.getFechaDevolucion());
        String templateName = "Loan";
        String contentHTML = templateEngine.process(templateName, context);

        try {
            EmailDTO emailDto = new EmailDTO();
            emailDto.setResponsableEconomico(loan.getResponsableEconomico().getEmail());
            emailDto.setAsunto("Recordatorio: PrestamoRealizado");
            emailDto.setMensaje(contentHTML);

            emailNotificationService.enviarCorreo(emailDto);

        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar notificación de préstamo por vencer: " + e.getMessage(), e);
        }

    }

    public void enviarNotificacionPrestamoPorVencer(Loan loan) {
        LocalDate fechaRecordatorio = loan.getFechaDevolucion().minusDays(3);
        if (LocalDate.now().isEqual(fechaRecordatorio)) {
            Context context = new Context();
            context.setVariable("responsableEconomico", loan.getResponsableEconomico().getNombre());
            context.setVariable("tituloLibro", loan.getLibroId());
            context.setVariable("isbn", loan.getIsbn());
            context.setVariable("fechaLimiteDevolucion", loan.getFechaDevolucion());

            String templateName = "LoanReminder";
            String contentHTML = templateEngine.process(templateName, context);

            try {
                EmailDTO emailDto = new EmailDTO();
                emailDto.setResponsableEconomico(loan.getResponsableEconomico().getEmail());
                emailDto.setAsunto("Recordatorio: Préstamo próximo a vencer");
                emailDto.setMensaje(contentHTML);

                emailNotificationService.enviarCorreo(emailDto);

            } catch (MessagingException e) {
                throw new RuntimeException("Error al enviar notificación de préstamo por vencer: " + e.getMessage(), e);
            }
        }
    }


    public void enviarnotificacionprestamovencido(Loan loan) throws MessagingException{
        if (LocalDate.now().isEqual(loan.getFechaDevolucion())){
        Context context = new Context();
        context.setVariable("responsableEconomico", loan.getResponsableEconomico().getNombre());
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

            emailNotificationService.enviarCorreo(emailDto); // Llama al método para enviar el correo
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar notificación de préstamo vencido: " + e.getMessage(), e);
        }
    }
    }



    public void enviarnotificacionmulta(Loan loan, Fines fines, Student student){
            Context context = new Context();
            context.setVariable("estudiante",student.getname());
            context.setVariable("responsableEconomico", loan.getResponsableEconomico().getNombre());
            context.setVariable("tituloLibro", loan.getLibroId());
            context.setVariable("isbn", loan.getIsbn());
            context.setVariable("fechaLimiteDevolucion", loan.getFechaDevolucion());
            context.setVariable("multaPorDia", fines.calcularMulta(2));

            context.setVariable(null, context);
    
            String templateName = "email_multa";
    
            String contentHTML = templateEngine.process(templateName, context);
    
            try {
                EmailDTO emailDto = new EmailDTO();
                emailDto.setResponsableEconomico(loan.getResponsableEconomico().getEmail());
                emailDto.setAsunto("Notificación de Multa");
                emailDto.setMensaje(contentHTML);
    
                emailNotificationService.enviarCorreo(emailDto); // Llama al método para enviar el correo
            } catch (MessagingException e) {
                throw new RuntimeException("Error al enviar notificación de multa: " + e.getMessage(), e);
            }
        }

    }
