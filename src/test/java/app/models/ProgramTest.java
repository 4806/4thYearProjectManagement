package app.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramTest {

    Program program1;

    @Before
    public void setUp() {
        program1 = new Program("Software Engineering", Program.Acronym.SOFT);
    }

    @Test
    public void getName() {
        assertEquals("Software Engineering", program1.getName());
    }

    @Test
    public void setName() {
        program1.setName("Computer Science");
        assertEquals("Computer Science", program1.getName());

    }

    @Test
    public void getAcronym() {
        assertEquals(Program.Acronym.SOFT, program1.getAcronym());

    }

    @Test
    public void setAcronym() {
        program1.setAcronym(Program.Acronym.COMP);
        assertEquals(Program.Acronym.COMP, program1.getAcronym());
    }
}