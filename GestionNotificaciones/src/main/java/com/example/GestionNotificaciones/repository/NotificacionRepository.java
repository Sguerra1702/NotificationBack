package com.example.GestionNotificaciones.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.GestionNotificaciones.entity.Notificacion;

public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
    
}
