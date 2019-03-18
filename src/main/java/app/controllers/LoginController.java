package app.controllers;

import app.models.User;
import app.models.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
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
    public String login(Model model, @CookieValue(name="username", defaultValue = "noUserCookie") String username, HttpServletRequest request) {
        if(username.equals("noUserCookie")){
            model.addAttribute("user", new User());
            //model.addAttribute("view", "login");
            model.addAttribute("loggedIn", true);

            return "layout";
        }
        else{
            return "redirect:";
        }

    }

    @PostMapping("/login")

    public String login(Model model, HttpServletResponse response, @Valid User user) {

        if(userService.authenticate(user.getUsername(), user.getPassword())){
            Cookie username = new Cookie("username", user.getUsername());
            username.setMaxAge(60*60);
            //Cookie role = new Cookie("role", user.getRole());
            //role.setMaxAge(60*60);
            response.addCookie(username);
            //response.addCookie(role);
            return "redirect:";

        }

        else{
            model.addAttribute("loggedIn", true);
            return "redirect:";
        }

    }

    @ResponseBody
    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie username = new Cookie("username", "");
        username.setMaxAge(0);
        Cookie role = new Cookie("role", "");
        role.setMaxAge(0);
        response.addCookie(username);
        response.addCookie(role);
        return "";
    }
}