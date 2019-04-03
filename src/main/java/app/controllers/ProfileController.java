package app.controllers;

import app.models.*;
import app.repositories.ProjectRepository;
import app.repositories.UserRepository;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.crypto.password.PasswordEncoder;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    private User user;
    @GetMapping("/profile")
    public String profilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user = userRepository.findByUsername(auth.getName());

         // model attributes for displaying User Info
        model.addAttribute("role", user.getRole());
        model.addAttribute("name", user.getUsername());
        model.addAttribute("program",user.getProgram().getName());

        // model attributes for getting form data
        // from  change password from  found under account setting section
        model.addAttribute("user", user);
        model.addAttribute("view", "profile");

        return "layout";
    }

    @PostMapping("/profile")
    public String  changePassword(Model model, @ModelAttribute User formUser) {

        // check the new password and confirm password match
        if (formUser.getPassword().equals(formUser.getConfPassword())) {
            user.setPassword(passwordEncoder.encode(formUser.getPassword()));
            user.setConfPassword(passwordEncoder.encode(formUser.getConfPassword()));
            userRepository.save(user);
            model.addAttribute("role", user.getRole());
            model.addAttribute("name", user.getUsername());
            model.addAttribute("user", user);
            model.addAttribute("view", "profile");
            model.addAttribute("resetSuccess", true);
            return "layout";
        } else {
            // if password do not match return an error message.
            model.addAttribute("role", user.getRole());
            model.addAttribute("name", user.getUsername());
            model.addAttribute("view", "profile");
            model.addAttribute("user", user);
            model.addAttribute("pwError", true);
            return "layout";
        }
    }

    @PostMapping("/updateAvailability")
    public String updateAvailability(Model model, User user){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User realUser = userRepository.findByUsername(auth.getName());
        realUser.setAvailability(user.getAvailability());
        userRepository.save(realUser);

        return "redirect:profile";

    }
}
