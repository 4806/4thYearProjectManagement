package app.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {

    User user;
    ArrayList<Project> projects;

    @Before
    public void setUp(){
        user = new User("JaneDoe","Hashedpassword1%", "Hashedpassword1%",  User.Role.STUDENT);

        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
        ArrayList<Program> programs = new ArrayList<Program>();
        programs.add(program);

        User student1 = new User("student1","1234","1234", program);
        User student2 = new User("student2","1234","1234", program);
        ArrayList<User> students = new ArrayList<User>();
        students.add(student1);
        students.add(student2);

        User supervisor = new User("Bailey", "1234", "1234", new ArrayList<Project>());

        Project project = new Project("project1", "Website", 3, supervisor, students, programs);
        projects = new ArrayList<>();
        projects.add(project);

        user.setProjects(projects);
        user.setAvailability(new ArrayList<>());
        user.setProgram(program);
    }

    @Test
    public void getUsername() {
        assertEquals("JaneDoe",user.getUsername());
    }

    @Test
    public void setUsername() {
        user.setUsername("JaneDoe123");
        assertEquals("JaneDoe123",user.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("Hashedpassword1%",user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("changePassword1%");
        assertEquals("changePassword1%",user.getPassword());
    }


    @Test
    public void getRole() {
        assertEquals(User.Role.STUDENT, user.getRole());
    }

    @Test
    public void setRole() {
        user.setRole(User.Role.SUPERVISOR);
        assertEquals(User.Role.SUPERVISOR,user.getRole());
    }

    @Test
    public void getProjects() {
        assertEquals(this.projects, user.getProjects());
    }

    @Test
    public void setProjects() {
        user.setProjects(new ArrayList<>());
        assertEquals(new ArrayList<>(), user.getProjects());
    }

    @Test
    public void getConfPassword() {
        assertEquals("Hashedpassword1%", user.getConfPassword());
    }

    @Test
    public void setConfPassword() {
        user.setConfPassword("1234");
        assertEquals("1234", user.getConfPassword());
    }

    @Test
    public void getProgram() {
        assertEquals(new Program("Software Engineering", Program.Acronym.SOFT), user.getProgram());
    }

    @Test
    public void setProgram() {
        user.setProgram(new Program("Comp Engineering", Program.Acronym.COMP));
        assertEquals(new Program("Comp Engineering", Program.Acronym.COMP), user.getProgram());
    }

}