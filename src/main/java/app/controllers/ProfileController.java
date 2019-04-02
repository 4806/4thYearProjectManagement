package app.controllers;

import app.models.*;
import app.repositories.ProjectRepository;
import app.repositories.UserRepository;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());


        model.addAttribute("user", user);
        model.addAttribute("view", "profile");
        return "layout";

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
