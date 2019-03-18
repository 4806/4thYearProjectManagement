package app.controllers;

import app.models.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ForgetPasswardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/forgot")
    public String dispalyforgotPasswordForm(Model model){
        return "forgotPassword";
    }
    @PostMapping("/forgot")
    public String processPasswordForm(){
        return "resetPassword";
    }

}
