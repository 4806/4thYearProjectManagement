
package app.repositories;

import app.models.Program;
import app.models.Project;
import app.models.Student;
import app.models.Supervisor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepoTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void findByNameTest() {
        Project project1 = new Project();
        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);
        Supervisor supervisor = new Supervisor("Rick", "pass", "pass", projects);

        Program program = new Program("Computer Science", Program.Acronym.COMP);
        Student student = new Student("", "", "", program);
        ArrayList<Student> students = new ArrayList<>();
        students.add(student);

        ArrayList<Program> programs = new ArrayList<>();
        programs.add(new Program());

        Project project = new Project("Tiny House", "", 6, supervisor, students, programs);
        projectRepository.save(project);
        Assert.assertNotNull(projectRepository.findAll());
    }
}
