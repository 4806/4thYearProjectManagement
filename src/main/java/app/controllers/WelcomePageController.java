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
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String welcome(@CookieValue(name="username", defaultValue = "noUserCookie") String username, HttpServletResponse response, Model model){

        if(username.equals("noUserCookie")){
            return "layout";
        }

        User temp = userRepository.findByUsername(username);
        if (temp == null) {
            Cookie user = new Cookie("username", "");
            user.setMaxAge(0);
            Cookie role = new Cookie("role", "");
            role.setMaxAge(0);
            response.addCookie(user);
            response.addCookie(role);
            return "layout";
        }


        model.addAttribute("user", temp);
        model.addAttribute("view", "index");
        return "layout";
    }
}
