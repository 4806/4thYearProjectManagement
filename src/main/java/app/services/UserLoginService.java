package app.services;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserLoginService implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        // check username and password
        return Objects.equals(username, password);
    }
}
