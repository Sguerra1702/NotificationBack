package edu.eci.cvds.NotificationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.eci.cvds.NotificationService.Model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
