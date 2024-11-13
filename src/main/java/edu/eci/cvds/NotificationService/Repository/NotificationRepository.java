package edu.eci.cvds.NotificationService.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.cvds.NotificationService.Model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, Long>{

}
