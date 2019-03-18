package app.controllers;

import app.models.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import app.models.UserRepository;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Map;

@Controller
public class WelcomePageController{

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(HttpServletResponse response, Model model){

//        model.addAttribute("user", temp);
        model.addAttribute("view", "index");
        return "layout";
    }
}
