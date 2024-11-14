package edu.eci.cvds.NotificationService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.cvds.NotificationService.Model.Load;

public interface LoadRepository extends MongoRepository<Load, String>{

    
}