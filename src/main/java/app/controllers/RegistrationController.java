package app.controllers;

import app.models.User;
import app.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:";
        }

        model.addAttribute("user", new User());
        model.addAttribute("view", "registration");
        return "layout";

    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        User temp = userRepository.findByUsername(user.getUsername());

        if(temp == null){
            if(user.getPassword().equals(user.getConfPassword())){

                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
                userRepository.save(user);
                return "redirect:login";
            }
            else{
                model.addAttribute("view", "registration");
                return "layout";
            }

        }
        else{
            model.addAttribute("view", "registration");
            return "layout";
        }


    }
}