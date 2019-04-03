package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProjectTest {

    Project project;
    ArrayList<Program> programs;
    ArrayList<User> students;

    @Before
    public void setUp() throws Exception {

        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
        programs = new ArrayList<Program>();
        programs.add(program);

        User student1 = new User("student1","1234","1234", program);
        User student2 = new User("student2","1234","1234", program);
        students = new ArrayList<User>();
        students.add(student1);
        students.add(student2);

        User supervisor = new User("Bailey", "1234", "1234", new ArrayList<Project>());

        this.project = new Project("project1", "Website", 3, supervisor, students, programs);
    }

    @Test
    public void getName() {
        assertEquals(project.getName(), "project1");
    }

    @Test
    public void setName() {
        project.setName("project2");
        assertEquals("project2", project.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Website", project.getDescription());
    }

    @Test
    public void setDescription() {
        project.setDescription("Website2");
        assertEquals("Website2", project.getDescription());
    }

    @Test
    public void getNumberStudents() {
        assertEquals(3, project.getNumberStudents());
    }

    @Test
    public void setNumberStudents() {
        project.setNumberStudents(4);
        assertEquals(4, project.getNumberStudents());
    }

    @Test
    public void getSupervisor() {
        assertEquals(new User("Bailey", "1234", "1234", new ArrayList<Project>()), project.getSupervisor());
    }

    @Test
    public void setSupervisor() {
        project.setSupervisor(new User("Babak", "5678", "5678", new ArrayList<Project>()));
        assertEquals(new User("Babak", "5678", "5678", new ArrayList<Project>()), project.getSupervisor());

    }

    @Test
    public void getStudents() {
        assertEquals(students, project.getStudents());
    }

    @Test
    public void setStudents() {
        ArrayList<User> newStudents = new ArrayList<User>();
        newStudents.add(new User("student3","5678","5678", programs.get(0)));
        newStudents.add(new User("student4","5678","5678", programs.get(0)));
        project.setStudents(newStudents);
        assertEquals(newStudents, project.getStudents());
    }

    public void addStudents(){
        ArrayList<User> newStudents = new ArrayList<User>();
        User student3 = new User("student3","5678","5678", programs.get(0));
        newStudents.add(student3);
        project.addStudent(student3);
        assertEquals(newStudents, project.getStudents());
    }

    @Test
    public void getRestrictions() {
        assertEquals(programs, project.getRestrictions());
    }

    @Test
    public void setRestrictions() {
        ArrayList<Program> newRestrictions = new ArrayList<Program>();
        newRestrictions.add(new Program("Computer Systems Engineering", Program.Acronym.COMP));
        project.setRestrictions(newRestrictions);
        assertEquals(newRestrictions, project.getRestrictions());
    }

    @Test
    public void getStatus() {
        assertEquals(Project.Status.ACTIVE, project.getStatus());
    }

    @Test
    public void setStatus() {
        project.setStatus(Project.Status.INACTIVE);
        assertEquals(Project.Status.INACTIVE, project.getStatus());
    }

    @Test
    public void activate(){
        project.setStatus(Project.Status.INACTIVE);
        project.activate();
        assertEquals(Project.Status.ACTIVE, project.getStatus());
    }

    @Test
    public void deactivate(){
        project.setStatus(Project.Status.ACTIVE);
        project.deactivate();
        assertEquals(Project.Status.INACTIVE, project.getStatus());
    }

    @Test
    public void isActive(){
        assertTrue(project.isActive());
    }

}