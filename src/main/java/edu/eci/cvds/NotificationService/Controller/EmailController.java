package edu.eci.cvds.NotificationService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.cvds.NotificationService.Repository.IEmailRepository;
import edu.eci.cvds.NotificationService.Model.EmailDTO;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Service.NotificationService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/notifications")
public class EmailController {

    @Autowired
    IEmailRepository emailRepository;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send-email")
    public ResponseEntity<String> enviarCorreo(@RequestBody EmailDTO emailDTO) throws MessagingException {
        // Obtener templateName desde el EmailDTO
        String templateName = emailDTO.getTemplateName();
        // Llamar al repositorio con los parámetros
        emailRepository.enviarCorreo(emailDTO);

        return new ResponseEntity<>("Correo enviado exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de préstamo realizado
    @PostMapping("/loan-made")
    public ResponseEntity<String> enviarNotificacionPrestamoRealizado(@RequestBody Loan loan) {
        notificationService.enviarNotificacionprestamorealizado(loan, loan.getEstudiante());
        return new ResponseEntity<>("Notificación de préstamo realizado enviada exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de préstamo por vencer
    @PostMapping("/loan-reminder")
    public ResponseEntity<String> enviarNotificacionPrestamoPorVencer(@RequestBody Loan loan) {
        notificationService.enviarNotificacionPrestamoPorVencer(loan);
        return new ResponseEntity<>("Notificación de préstamo por vencer enviada exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de préstamo vencido
    @PostMapping("/loan-overdue")
    public ResponseEntity<String> enviarNotificacionPrestamoVencido(@RequestBody Loan loan) throws MessagingException {
        notificationService.enviarnotificacionprestamovencido(loan);
        return new ResponseEntity<>("Notificación de préstamo vencido enviada exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de multa
    @PostMapping("/fine")
    public ResponseEntity<String> enviarNotificacionMulta(@RequestParam String message, @RequestParam double multa) {
        notificationService.enviarnotificacionmulta(message, multa);
        return new ResponseEntity<>("Notificación de multa enviada exitosamente", HttpStatus.OK);
    }
}
