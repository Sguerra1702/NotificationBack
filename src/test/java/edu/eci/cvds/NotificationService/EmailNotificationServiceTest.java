package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.EmailDTO;
import edu.eci.cvds.NotificationService.Model.Loan;
import edu.eci.cvds.NotificationService.Model.ResponsableEconomic;
import edu.eci.cvds.NotificationService.Model.Student;
import edu.eci.cvds.NotificationService.Service.EmailNotificationService;
import edu.eci.cvds.NotificationService.Model.Fines;
import edu.eci.cvds.NotificationService.Service.NotificationService;



import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.mail.MessagingException;


@SpringBootTest
public class EmailNotificationServiceTest {

    @Autowired
    private NotificationService notificationService;


    @Autowired
    private EmailNotificationService emailNotificationService;  // El servicio de correo


    /* 
    @Test
    public void testEnviarCorreo() throws MessagingException {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setResponsableEconomico("NataliaPaez993@gmail.com");  // Dirección de correo de prueba
        emailDTO.setAsunto("Funciona");
        emailDTO.setMensaje("Me debes esta vida y la otra");

        emailNotificationService.enviarCorreo(emailDTO);

    }
    */
    
    /* 
    @Test
    public void testEnviarNotificacionPrestamoVencido() throws MessagingException {
        // Configuración del objeto Loan de prueba
        Loan loan = new Loan();
        loan.setLibroId("Introducción a Java");
        loan.SetIsbn("978-3-16-148410-0");
        loan.setFechaLoan(LocalDate.of(2024, 11, 10));
        loan.setFechaDevolucion(LocalDate.now());

        ResponsableEconomic responsable = new ResponsableEconomic();
        responsable.setNombre("Natalia Páez");
        responsable.setEmail("rodriguezandres160918@gmail.com");
        loan.setResponsableEconomico(responsable);

         // Llamar al método para enviar el correo
         notificationService.enviarnotificacionprestamovencido(loan);
    }
    */
    /* 
    @Test
    public void testEnviarNotificacionPrestamoPorVencer() throws MessagingException {
        // Configuración del objeto Loan de prueba
        Loan loan = new Loan();
        loan.setLibroId("Introducción a Java");
        loan.SetIsbn("978-3-16-148410-0");
        loan.setFechaLoan(LocalDate.of(2024, 11, 10));
        loan.setFechaDevolucion(LocalDate.now().plusDays(3)); // Fecha de devolución en 3 días

        ResponsableEconomic responsable = new ResponsableEconomic();
        responsable.setNombre("Natalia Páez");
        responsable.setEmail("felipebarrera104@gmail.com");
        loan.setResponsableEconomico(responsable);

        // Llamar al método para enviar el correo
        notificationService.enviarNotificacionPrestamoPorVencer(loan);
    }
    */
    /* 
    @Test
    public void testEnviarNotificacionPrestamoRealizado() throws MessagingException {

        Student student = new Student();
        student.setname("Manuel Barrera");

        Loan loan = new Loan();
        loan.setNameBook("Introducción a Java");
        loan.setId((long) (978-3-16-148410-0));
        loan.setLoanDate(LocalDate.of(2024, 11, 10));
        loan.setMaxReturnDate(LocalDate.now());

        ResponsableEconomic responsable = new ResponsableEconomic();
        responsable.setNombre("Natalia Páez");
        responsable.setEmail("rodriguezandres160918@gmail.com");

        // Llamar al método para enviar el correo
        notificationService.enviarNotificacionprestamorealizado(loan);
    }
    
    /* 
    @Test
    public void testEnviarNotificacionMulta() throws MessagingException {

        Student student = new Student();
        student.setname("Manuel Barrera");

        Loan loan = new Loan();
        loan.setId("Introducción a Java");
        loan.SetIsbn("978-3-16-148410-0");
        loan.setFechaLoan(LocalDate.of(2024, 11, 10));
        loan.setFechaDevolucion(LocalDate.now());
        Fines fines = new Fines();
        fines.calcularMulta(2);
        

        ResponsableEconomic responsable = new ResponsableEconomic();
        responsable.setNombre("Natalia Páez");
        responsable.setEmail("rodriguezandres160918@gmail.com");
        loan.setResponsableEconomico(responsable);

        // Llamar al método para enviar el correo
        notificationService.enviarnotificacionmulta(loan,fines,student);
    }
        */
}
