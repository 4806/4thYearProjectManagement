
package app.repositories;

import app.models.*;
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
        project1.setName("p1");
        projectRepository.save(project1);
        Assert.assertNotNull(projectRepository.findByName("p1"));
    }
}
