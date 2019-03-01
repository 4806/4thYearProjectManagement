package app.services;

import app.models.User;
import app.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.Objects;

@Service
public class UserLoginService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        // check username and password
         User user = userRepository.findByUsername(username);
         String u_name = user.getUsername();
         String pass = user.getPassword();
        return u_name.equals(username) && pass.equals(password);
    }

}
