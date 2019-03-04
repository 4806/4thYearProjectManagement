package app.controllers;

import app.models.User;
import app.models.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        if(userService.userExist(user.getUsername())
                && userService.verifyUserRole(user.getUsername(), user.getRole())){
            //To Do: if username already in database  dispaly a message to
            // let the user that he is already registred  and then display the login form
            // to avoid saving the user agin in the database
            return "login";
        }
        userRepository.save(user);
        return "login";
    }
}