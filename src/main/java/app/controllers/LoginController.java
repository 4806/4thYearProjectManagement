package app.controllers;

import app.models.User;
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

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid User user) {
        if (!userService.authenticate(user.getUsername(), user.getPassword())) {
            // if the user name and password not matching display the loginForm again
            return "/login";
        }

        //if the username and password match display user page
        return "userPage";
    }
}


