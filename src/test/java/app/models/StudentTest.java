package app.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Student student1;

    @Before
    public void setUp() throws Exception {
        Program program1 = new Program("Software Engineering", Program.Acronym.SOFT);
        student1 = new Student("student1", "1234", "1234", program1);
    }

    @Test
    public void getProgram() {
        assertEquals(new Program("Software Engineering", Program.Acronym.SOFT), student1.getProgram());
    }

    @Test
    public void setProgram() {
        student1.setProgram(new Program("Computer Systems Engineering", Program.Acronym.COMP));
        assertEquals(new Program("Computer Systems Engineering", Program.Acronym.COMP), student1.getProgram());
    }
}