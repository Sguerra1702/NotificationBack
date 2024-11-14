package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import edu.eci.cvds.NotificationService.Model.ResponsableEconomic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


@SpringBootTest
class NotificationServiceApplicationTests {
	
	LocalDate date = LocalDate.now();
	ResponsableEconomic responsableEconomic;

	@Test
	void testDefaultConstructor() {
		Notification notification = new Notification();
		assertNull(notification.getId());
		assertNull(notification.getmessage());
		assertNull(notification.getdate());
		assertNull(notification.getBookId());
		assertNull(notification.getStudentId());
		assertNull(notification.getResponsableEconomic());
		assertNull(notification.getType());
		assertNull(notification.getMount());
		assertNull(notification.getState());
	}

	@Test
	void testParameterizedConstructor() {
		Notification notification = new Notification("1", NotificationType.LOAN_MADE,date, 1001L, 2002L, responsableEconomic, "Active", "Test message", 50.0);

		assertEquals("1", notification.getId());
		assertEquals(NotificationType.LOAN_MADE, notification.getType());
		assertEquals(date, notification.getdate());
		assertEquals(1001, notification.getBookId());
		assertEquals(2002L, notification.getStudentId());
		assertEquals(responsableEconomic, notification.getResponsableEconomic());
		assertEquals("Active", notification.getState());
		assertEquals("Test message", notification.getmessage());
		assertEquals(50.0, notification.getMount());
	}
	 
	@Test
	void testSettersAndGetters() {
		Notification notification = new Notification();

		notification.setId("2");
		notification.setmessage("New Message");
		notification.setdate(date);
		notification.setBookId(1010L);
		notification.setStudentId(2002L);
		notification.setResponsableEconomic(responsableEconomic);
		notification.setstate("Pending");
		notification.setType(NotificationType.LOAN_REMINDER);
		notification.setMount(75.5);

		assertEquals("2", notification.getId());
		assertEquals("New Message", notification.getmessage());
		assertEquals(date, notification.getdate());
		assertEquals(1010L, notification.getBookId());
		assertEquals(2002L, notification.getStudentId());
		assertEquals(responsableEconomic, notification.getResponsableEconomic());
		assertEquals("Pending", notification.getState());
		assertEquals(NotificationType.LOAN_REMINDER, notification.getType());
		assertEquals(75.5, notification.getMount());
	}
	
	@Test
	void testLoanOverdueType() {
		Notification notification = new Notification();
		notification.setType(NotificationType.LOAN_OVERDUE);
		assertEquals(NotificationType.LOAN_OVERDUE, notification.getType());
	}

	@Test
	void testFineType() {
		Notification notification = new Notification();
		notification.setType(NotificationType.FINE);
		assertEquals(NotificationType.FINE, notification.getType());
	}
	
}
