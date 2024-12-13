package edu.eci.cvds.NotificationService.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import edu.eci.cvds.NotificationService.Repository.IEmailRepository;
import edu.eci.cvds.NotificationService.Model.Fines;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Model.Student;
import edu.eci.cvds.NotificationService.Service.NotificationService;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/notifications")
public class EmailController {

    @Autowired
    IEmailRepository emailRepository;
    
    @Autowired
    private NotificationService notificationService;



    // Endpoint para enviar notificación de préstamo realizado

    @PostMapping("/loan-made")
    public ResponseEntity<String> endpointNotificacionprestamorealizado(@RequestBody Loan loan) {
    try {
        // Verificar si la fecha de vencimiento está dentro de los próximos 3 días
        LocalDate fechaLimiteDevolucion = loan.getMaxReturnDate();
        LocalDate fechaActual = LocalDate.now();
        long diasDeDiferencia = ChronoUnit.DAYS.between(fechaActual, fechaLimiteDevolucion);

        if(diasDeDiferencia <= 3) {
            notificationService.enviarNotificacionPrestamoPorVencer(loan);
        } else {
            notificationService.enviarNotificacionprestamorealizado(loan);
        }

        return new ResponseEntity<>("Notificación enviada exitosamente", HttpStatus.OK);

    } catch (Exception e) {
        // Captura cualquier excepción y muestra un mensaje detallado
        return new ResponseEntity<>("Error en el servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("Service is up and running!", HttpStatus.OK);
    }

}
