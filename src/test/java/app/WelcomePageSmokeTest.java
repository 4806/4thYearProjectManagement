package app;

import app.controllers.WelcomePageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomePageSmokeTest {

    @Autowired
    private WelcomePageController welcomeController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(welcomeController).isNotNull();
    }
}