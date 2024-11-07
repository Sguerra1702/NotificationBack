package com.example.GestionNotificaciones.repository;

import com.example.GestionNotificaciones.entity.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ResponsableEconomicoRepository extends MongoRepository<Prestamo, String> {

}
