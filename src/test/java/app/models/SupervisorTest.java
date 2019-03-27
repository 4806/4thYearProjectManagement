package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SupervisorTest {

    Supervisor supervisor;
    ArrayList<User> students;
    ArrayList<Program> programs;

    @Before
    public void setUp() throws Exception {

        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
        programs = new ArrayList<Program>();
        programs.add(program);

        Student student1 = new Student("student1","1234","1234", program);
        Student student2 = new Student("student2","1234","1234", program);
        students = new ArrayList<User>();
        students.add(student1);
        students.add(student2);

        supervisor = new Supervisor("Bailey", "1234", "1234", new ArrayList<Project>());
        supervisor.addProject(new Project("project1", "Website", 3, supervisor, students, programs));
    }

    @Test
    public void addProject() {
        Project project2 = (new Project("project2", "Website2", 6, supervisor, students, programs));
        supervisor.addProject(project2);
        ArrayList<Project> projects = supervisor.getProjects();
        projects.add(project2);
        assertEquals(projects, supervisor.getProjects());
    }

    @Test
    public void getProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project("project1", "Website", 3, supervisor, students, programs));
        assertEquals(projects, supervisor.getProjects());
    }

    @Test
    public void setProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();
        supervisor.setProjects(projects);
        assertEquals(projects, supervisor.getProjects());
    }
}