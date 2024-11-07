package com.example.GestionNotificaciones.repository;

import com.example.GestionNotificaciones.entity.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
    
}
