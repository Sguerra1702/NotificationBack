package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.Notification;
import edu.eci.cvds.NotificationService.Model.NotificationType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

@SpringBootTest
class NotificationServiceApplicationTests {

	@Test
	void testDefaultConstructor() {
		Notification notification = new Notification();
		assertEquals(0, notification.getId());
		assertNull(notification.getmessage());
		assertNull(notification.getLocaldate());
		assertEquals(0, notification.getBookId());
		assertEquals(0, notification.getStudentId());
		assertEquals(0, notification.getResponsableID());
		assertNull(notification.getState());
		assertNull(notification.getType());
	}

	@Test
	void testParameterizedConstructor() {
		LocalDateTime now = LocalDateTime.now();
		Notification notification = new Notification(1, NotificationType.LOAN_MADE, now, 1001, 2002, 3003, "Active", "Test message", 50.0);

		assertEquals(1, notification.getId());
		assertEquals(NotificationType.LOAN_MADE, notification.getType());
		assertEquals(now, notification.getLocaldate());
		assertEquals(1001, notification.getBookId());
		assertEquals(2002, notification.getStudentId());
		assertEquals(3003, notification.getResponsableID());
		assertEquals("Active", notification.getState());
		assertEquals("Test message", notification.getmessage());
		assertEquals(50.0, notification.getMount());
	}

	@Test
	void testSettersAndGetters() {
		Notification notification = new Notification();
		LocalDateTime time = LocalDateTime.now();

		notification.setId(2);
		notification.setmessage("New Message");
		notification.setLocaldate(time);
		notification.setBookId(1010);
		notification.setStudentId(2020);
		notification.setResponsableId(3030);
		notification.setState("Pending");
		notification.setType(NotificationType.LOAN_REMINDER);
		notification.setMount(75.5);

		assertEquals(2, notification.getId());
		assertEquals("New Message", notification.getmessage());
		assertEquals(time, notification.getLocaldate());
		assertEquals(1010, notification.getBookId());
		assertEquals(2020, notification.getStudentId());
		assertEquals(3030, notification.getResponsableID());
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
