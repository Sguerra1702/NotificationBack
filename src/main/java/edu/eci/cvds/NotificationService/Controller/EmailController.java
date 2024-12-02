package edu.eci.cvds.NotificationService.Controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import edu.eci.cvds.NotificationService.Repository.IEmailRepository;
import edu.eci.cvds.NotificationService.Model.Fines;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Model.ResponsableEconomic;
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

    @GetMapping("/loan-made")
    public ResponseEntity<String> endpointNotificacionprestamorealizado() {

        Student student = new Student();
        student.setname("Manuel Barrera");

        Loan loan = new Loan();
        loan.setLibroId("Introducción a Java");
        loan.SetIsbn("978-3-16-148410-0");
        loan.setFechaLoan(LocalDate.of(2024, 11, 10));
        loan.setFechaDevolucion(LocalDate.now());

        ResponsableEconomic responsable = new ResponsableEconomic();
        responsable.setNombre("Natalia Páez");
        responsable.setEmail("rodriguezandres160918@gmail.com");
        loan.setResponsableEconomico(responsable);

        // Llamamos al método de enviar notificación
        notificationService.enviarNotificacionprestamorealizado(loan, student);

        return new ResponseEntity<>("Notificacion enviada exitosamente ", HttpStatus.OK);
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
    public ResponseEntity<String> enviarNotificacionMulta(@RequestBody Loan loan, @RequestBody Fines fines, @RequestParam Student student) {
        notificationService.enviarnotificacionmulta(loan, fines, student);
        return new ResponseEntity<>("Notificación de multa enviada exitosamente", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("Service is up and running!", HttpStatus.OK);
    }

    @GetMapping("/test")
        public ResponseEntity<String> testEndpoint() {
            return ResponseEntity.ok("Test OK");
}

}
