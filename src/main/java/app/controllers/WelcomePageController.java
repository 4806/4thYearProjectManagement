package app.controllers;

import app.models.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.models.UserRepository;
import org.springframework.web.bind.annotation.CookieValue;

@Controller
public class WelcomePageController{

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String welcome(@CookieValue(name="username", defaultValue = "noUserCookie") String username) {

        if(username.equals("noUserCookie")){
            return "redirect:login";
        }

        User temp = userRepository.findByUsername(username);
        if (temp == null) {
            return "redirect:login";
        } else if (!temp.getUsername().equals(username)) {
            return "redirect:login";
        }

        return "index";
    }
}
