package app.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User user = new User("JaneDoe","Hashedpassword1%","Student");

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
        assertEquals("Student",user.getRole());

    }

    @Test
    public void setRole() {
        user.setRole("Teacher");
        assertEquals("Teacher",user.getRole());
    }
}