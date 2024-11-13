package edu.eci.cvds.NotificationService.Service;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Model.ResponsableEconomic;
import edu.eci.cvds.NotificationService.Service.EmailNotificationService;
/*import edu.eci.cvds.NotificationService.Repository.NotificationRepository;*/
@Service
public class NotificationService {
    @Autowired
    //private NotificationRepository notificationRepository;
    private EmailNotificationService emailNotificationService;
    
        private void sendNotification(String id,NotificationType type,LocalDate date, long bookID, long studentID, ResponsableEconomic responsableEconomic, double mount) {
            String message;
            String subject;
            switch(type){
                case LOAN_MADE:
                subject = "PRESTAMO REALIZADO";
                message = "prestamo realizado, fecha limite de devolucion" + date;
                break;
                case LOAN_REMINDER:
                subject = "RECORDATORIO DE PRESTAMO";
                message = "el recordatorio vence en 3 dias ";
                break;
                case LOAN_OVERDUE:
                subject= "PRESTAMO VENCIDO";
                message = "Se vencio el prestamo, devuelva el libro";
                break;
                case FINE:
                subject= "NOTIFICACION DE MULTA";
                message = "Notificacion de multa, debe pagar" +mount;
                break;
            default:
                throw new IllegalArgumentException("no se de que me hablas viejo" + type);
            }

        Notification notification = new Notification();
        notification.setId(id);
        notification.setType(type);
        notification.setdate(date);
        notification.setBookId(bookID);
        notification.setStudentId(studentID);
        notification.setResponsableEconomic(responsableEconomic);
        notification.setmessage(message);
        //notificationRepository.save(notification);
        
        String to = "rodriguezandres160918@gmail.com";
        emailNotificationService.sendEmail(to, subject, message);
        System.out.println("Notificacion enviada");
        }


    };

