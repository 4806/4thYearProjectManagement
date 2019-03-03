package app.controllers;

import app.models.User;
import app.models.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid User user) {
        User temp = userRepository.findByUsername(user.getUsername());

        //Todo: Implement Proper Authentication as a Service
        if (temp == null) {
            return "login";
        } else if (!temp.getUsername().equals(user.getUsername())) {
            return "login";
        }

        //Todo: Check if user Passwords match (hashes)
        //if the username and password match display user page
        return "userPage";
    }
}