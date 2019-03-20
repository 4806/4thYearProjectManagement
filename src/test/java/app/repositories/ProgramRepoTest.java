package app.repositories;

import app.models.Program;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramRepoTest {

    @Autowired
    private ProgramRepository programRepository;

    @Test
    public void findByNameTest() {
        Program program = new Program("Computer Science", Program.Acronym.COMP);
        programRepository.save(program);
        Assert.assertNotNull(programRepository.findByName("Computer Science"));
    }
}
