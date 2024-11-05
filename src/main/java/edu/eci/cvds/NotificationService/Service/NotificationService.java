package edu.eci.cvds.NotificationService.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Repository.NotificationRepository;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(long bookID, long studentID, String message, String state){
        Notification notification = new Notification();
        notification.setmessage("el libro ha sido prestado");
        notification.setLocaldate(LocalDateTime.now());
        notification.setBookId(bookID);
        notification.setStudentId(studentID);
        notification.setResponsableId(studentID);
        notification.setState(state);
        //notificationRepository.save(notification);

    };
}
