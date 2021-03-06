package app.controllers;

import app.models.User;
import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:";
        }

        model.addAttribute("user", new User());
        model.addAttribute("view", "login");
        return "layout";

    }
    @GetMapping("/login-logout")
    public String loggedOut(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:logout";
        }

        model.addAttribute("user", new User());
        model.addAttribute("view", "login");
        model.addAttribute("logout", true);
        return "layout";

    }


    @GetMapping("/login-error")
    public String loginError(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:";
        }

        model.addAttribute("loginError", true);
        model.addAttribute("user", new User());
        model.addAttribute("view", "login");
        return "layout";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletResponse response, @Valid User user) {

        if(userService.authenticate(user.getUsername(), user.getPassword())){
            model.addAttribute("view", "index" );
            return "redirect:";

        }

        else{
            model.addAttribute("view", "login");
            return "layout";
        }

    }


}