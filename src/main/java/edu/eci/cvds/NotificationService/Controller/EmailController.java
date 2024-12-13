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
public ResponseEntity<String> endpointNotificacionprestamorealizado(@RequestBody Map<String, Object> loanData) {
    try {
        String studentId = (String) loanData.get("studentId");
        String studentName = (String) loanData.get("studentName");
        String bookId = (String) loanData.get("bookId");
        String nameBook = (String) loanData.get("nameBook");
        LocalDate loanDate = LocalDate.parse((String) loanData.get("loanDate"));
        LocalDate maxReturnDate = LocalDate.parse((String) loanData.get("maxReturnDate"));

        
        // Crear un objeto Loan a partir de los datos recibidos
        Loan loan = new Loan(studentId, studentName, bookId, nameBook, nameBook, loanDate, maxReturnDate, null);
        
        // Verificar si la fecha de vencimiento está dentro de los próximos 3 días
        LocalDate fechaLimiteDevolucion = loan.getMaxReturnDate();
        LocalDate fechaActual = LocalDate.now();
        long diasDeDiferencia = ChronoUnit.DAYS.between(fechaActual, fechaLimiteDevolucion);

        if(diasDeDiferencia <= 3) {
            // Si el préstamo está por vencer, enviar notificación de préstamo por vencer
            notificationService.enviarNotificacionPrestamoPorVencer(loan);
        } else {
            // De lo contrario, enviar la notificación de préstamo realizado
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
