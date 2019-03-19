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
        assertEquals(project.getName(), "FRAMM");
    }

    @Test
    public void getDescription() {
        assertEquals(project.getDescription(), "Movie identification");
    }

    @Test
    public void setDescription() {
        project.setDescription("Facial Rec");
        assertEquals(project.getName(), "Facial Rec");
    }

    @Test
    public void getNumberStudents() {
    }

    @Test
    public void setNumberStudents() {
    }

    @Test
    public void getSupervisor() {
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