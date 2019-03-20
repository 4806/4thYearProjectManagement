package app.repositories;

import app.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsernameTest() {
        User user = new User("babak", "password", "password", User.Role.SUPERVISOR);
        userRepository.save(user);
        Assert.assertNotNull(userRepository.findByUsername("babak"));
    }
}
