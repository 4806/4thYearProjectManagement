package app.services;

import app.models.User;
import app.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean verifyNameAndPassword(String username, String password) {
        // check username and password
        User user = userRepository.findByUsername(username);
        String u_name = user.getUsername();
        String pass = user.getPassword();
        return u_name.equals(username) && pass.equals(password);
    }

    boolean verifyUserRole (String username, String role){
        User user = userRepository.findByUsername(username);
        String dataBase_role = user.getRole();
        return role.equals(dataBase_role);
    }
}
