package com.example.GestionNotificaciones.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestionNotificaciones.entity.Notificacion;
import com.example.GestionNotificaciones.entity.Prestamo;
import com.example.GestionNotificaciones.repository.NotificacionRepository;

@Service
public class GestorNotificaciones {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public void enviarNotificacionesPrestamoRealizado(String mensaje){
        Notificacion notificacion = new Notificacion();
        notificacion.setTipo("Prestamo Realizado");
        notificacion.setMensaje(mensaje);
        notificacion.setFechaEnvio(LocalDate.now());
        notificacionRepository.save(notificacion);
    }

    //Los recordatorios se enviaran 3 días antes
    public void enviarRecordatorioPrestamoPorVencer(LocalDate fechaDevolucion, String mensaje){
        LocalDate fechaRecordatorio = fechaDevolucion.minus(3, ChronoUnit.DAYS);

        if(LocalDate.now().equals(fechaRecordatorio)){
            Notificacion notificacion = new Notificacion();
            notificacion.setTipo("Recordatorio préstamo por vencer");
            notificacion.setMensaje(mensaje);
            notificacion.setFechaEnvio(LocalDate.now());
            notificacionRepository.save(notificacion);
            }

    }

    public void enviarNotificacionPrestamoVencido(Prestamo prestamo) {
        if (LocalDate.now().isEqual(prestamo.getFechaDevolucion())) {
            String mensaje = "El préstamo ha vencido. Por favor, devuelva el libro lo antes posible.";
            Notificacion notificacion = new Notificacion("PRESTAMO_VENCIDO", mensaje, LocalDate.now(), prestamo.getResponsableEconomico());
            notificacionRepository.save(notificacion);
        }
    }

    public void enviarNotificacionMulta(String mensaje, double montoMulta) {
        Notificacion notificacion = new Notificacion();
        notificacion.setTipo("Multa");
        notificacion.setMensaje(mensaje + " Monto de la multa: $" + montoMulta);
        notificacion.setFechaEnvio(LocalDate.now());
        notificacionRepository.save(notificacion);
    }
}