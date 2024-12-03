package edu.eci.cvds.NotificationService.Controller;

import java.time.LocalDate;
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

    @Autowired
    private RestTemplate restTemplate;

    private final String studenturl = "";
    private final String Loanurl = "";


    // Endpoint para enviar notificación de préstamo realizado

    @GetMapping("/loan-made")
    public ResponseEntity<String> endpointNotificacionprestamorealizado() {


        Long StudentName = 1L;
        Long bodyLoan = 1L;

        ResponseEntity<Student> studentResponse = restTemplate.exchange(studenturl + StudentName,HttpMethod.GET, null, Student.class);
        ResponseEntity<Loan> loanResponse = restTemplate.exchange(Loanurl + bodyLoan,HttpMethod.GET, null, Loan.class);
        
        Student student = studentResponse.getBody();
        Loan loan = loanResponse.getBody();

        // Llamamos al método de enviar notificación
        notificationService.enviarNotificacionprestamorealizado(loan, student);

        return new ResponseEntity<>("Notificacion enviada exitosamente ", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de préstamo por vencer
    @GetMapping("/loan-reminder")
    public ResponseEntity<String> enviarNotificacionPrestamoPorVencer() {
        
        Long bodyLoan = 1L;

        ResponseEntity<Loan> loanResponse = restTemplate.exchange(Loanurl + bodyLoan,HttpMethod.GET, null, Loan.class);
        Loan loan = loanResponse.getBody();
        
        notificationService.enviarNotificacionPrestamoPorVencer(loan);
        return new ResponseEntity<>("Notificación de préstamo por vencer enviada exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de préstamo vencido
    @GetMapping("/loan-overdue")
    public ResponseEntity<String> enviarNotificacionPrestamoVencido() throws MessagingException {

        Long bodyLoan = 1L;

        ResponseEntity<Loan> loanResponse = restTemplate.exchange(Loanurl + bodyLoan,HttpMethod.GET, null, Loan.class);
        Loan loan = loanResponse.getBody();
        
        notificationService.enviarnotificacionprestamovencido(loan);
        return new ResponseEntity<>("Notificación de préstamo vencido enviada exitosamente", HttpStatus.OK);
    }

    // Endpoint para enviar notificación de multa
    @GetMapping("/fine")
    public ResponseEntity<String> enviarNotificacionMulta(@RequestParam Fines fines) {

        Long StudentName = 1L;
        Long bodyLoan = 1L;

        ResponseEntity<Student> studentResponse = restTemplate.exchange(studenturl + StudentName,HttpMethod.GET, null, Student.class);
        ResponseEntity<Loan> loanResponse = restTemplate.exchange(Loanurl + bodyLoan,HttpMethod.GET, null, Loan.class);
        
        Student student = studentResponse.getBody();
        Loan loan = loanResponse.getBody();


        notificationService.enviarnotificacionmulta(loan, fines, student);
        return new ResponseEntity<>("Notificación de multa enviada exitosamente", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("Service is up and running!", HttpStatus.OK);
    }


}
