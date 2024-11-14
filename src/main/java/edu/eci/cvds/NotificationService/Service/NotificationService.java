package edu.eci.cvds.NotificationService.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.NotificationService.Model.Load;
import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Repository.NotificationRepository;
@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void enviarNotificacionprestamorealizado(String message){

        Notification notification = new Notification();
        notification.setType(NotificationType.LOAN_MADE);
        notification.setmessage(message);
        notification.setdate(LocalDate.now());
        notificationRepository.save(notification);
    }

    public void enviarNotificacionprestamoavencer(LocalDate fechaDevolucion, String message){
        LocalDate fechaRecordatorio = fechaDevolucion.minus(3, ChronoUnit.DAYS);

        if(LocalDate.now().equals(fechaRecordatorio)){
            Notification notification =new Notification();
            notification.setType(NotificationType.LOAN_REMINDER);
            notification.setmessage(message);
            notification.setdate(LocalDate.now());
            notificationRepository.save(notification);

        }

    }

    public void enviarnotificacionprestamovencido(Load load){
        if(LocalDate.now().isEqual(load.getFechaDevolucion()));
            String message = "el prestamo ha vencido, por favor devuelva el libr0";
            Notification notification = new Notification("Prestamo vencido", message, LocalDate.now(), load.getResponsableEconomico());
            notification.setType(NotificationType.LOAN_OVERDUE);
            notificationRepository.save(notification);
        }



    public void enviarnotificacionmulta(String message, double multa){
        Notification notification = new Notification();
        notification.setType(NotificationType.FINE);
        notification.setmessage(message + "monto de la multa: $" + multa);
        notificationRepository.save(notification);
    }
    }

