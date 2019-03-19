
package app.repositories;

import app.models.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectRepoTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void findByNameTest() {
        Project project = new Project("Tiny House", "", 6, null, null, null);
        projectRepository.save(project);
        Assert.assertNotNull(projectRepository.findByName("Tiny House"));
    }
}
