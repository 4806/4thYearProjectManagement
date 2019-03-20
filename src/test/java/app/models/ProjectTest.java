package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectTest {

    Project project;

    @Before
    public void setUp() throws Exception {

        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
        ArrayList<Program> programs = new ArrayList<Program>();
        programs.add(program);

        Student student1 = new Student("Geoff","1234","1234", program);
        Student student2 = new Student("Ethan","1234","1234", program);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);

        Supervisor supervisor = new Supervisor("Bailey", "1234", "1234");

        this.project = new Project("FRAME", "Movie identification", 3, supervisor, students, programs);
    }

    @Test
    public void getName() {
        assertEquals(project.getName(), "FRAME");
    }

    @Test
    public void setName() {
        project.setName("FRAMM");
        assertEquals("FRAMM", project.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Movie identification", project.getDescription());
    }

    @Test
    public void setDescription() {
        project.setDescription("Facial Rec");
        assertEquals("Facial Rec", project.getDescription());
    }

    @Test
    public void getNumberStudents() {
        assertEquals("Movie identification", project.getNumberStudents());
    }

    @Test
    public void setNumberStudents() {
        project.setDescription("Facial");
        assertEquals("Facial", project.getDescription());
    }

    @Test
    public void getSupervisor() {
        assertEquals("Movie identification", project.getNumberStudents());

    }

    @Test
    public void setSupervisor() {
    }

    @Test
    public void getStudents() {
    }

    @Test
    public void setStudents() {
    }

    @Test
    public void getRestrictions() {
    }

    @Test
    public void setRestrictions() {
    }

    @Test
    public void getStatus() {
    }

    @Test
    public void setStatus() {
    }
}