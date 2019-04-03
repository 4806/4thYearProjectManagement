package app.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User user = new User("JaneDoe","Hashedpassword1%", "Hashedpassword1%",  User.Role.STUDENT);

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
}