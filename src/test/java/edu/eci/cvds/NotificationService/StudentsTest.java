package edu.eci.cvds.NotificationService;

import edu.eci.cvds.NotificationService.Model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class studentsTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Juan", "Pérez", "A1234");
    }

    @Test
    void contextLoads() {
        assertNotNull(student);
    }

    @Test
    void testGetters() {
        assertEquals("Juan", student.getname());
        assertEquals("Pérez", student.getlastname());
        assertEquals("A1234", student.getcode());
    }

    @Test
    void testSetters() {
        student.setname("María");
        student.setlastname("Gómez");
        student.setcode("B5678");

        assertEquals("María", student.getname());
        assertEquals("Gómez", student.getlastname());
        assertEquals("B5678", student.getcode());
    }

    @Test
    void testId() {
        student.setId("12345");
        assertEquals("12345", student.getId());
    }

    @Test
    void testConstructorWithoutId() {
        Student nuevostudent = new Student("Ana", "López", "C7890");
        assertEquals("Ana", nuevostudent.getname());
        assertEquals("López", nuevostudent.getlastname());
        assertEquals("C7890", nuevostudent.getcode());
        assertNull(nuevostudent.getId());
    }
}
