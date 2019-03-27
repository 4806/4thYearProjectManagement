package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CoordinatorTest {

    Coordinator coordinator1;
    ArrayList<Program> programs;

    @Before
    public void setUp() {
        programs = new ArrayList<Program>();
        Program program1 = new Program("Software Engineering", Program.Acronym.SOFT);
        Program program2 = new Program("Computer Systems Engineering", Program.Acronym.COMP);
        programs.add(program1);
        programs.add(program2);
        coordinator1 = new Coordinator("coord1", "1234", "1234", programs);
    }

    @Test
    public void getPrograms() {
        assertEquals(programs, coordinator1.getPrograms());
    }

    @Test
    public void setPrograms() {
        ArrayList<Program> newPrograms = new ArrayList<Program>();
        newPrograms.add(new Program("Mechanical Engineering", Program.Acronym.MECH));
        coordinator1.setPrograms(newPrograms);
        assertEquals(newPrograms, coordinator1.getPrograms());
    }

}