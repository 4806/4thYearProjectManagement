package app.controllers;

import app.models.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult , Model model ) {


        if (!userService.authenticate(user.getUsername(), user.getPassword())) {
            // if the user name and passwrod not matching display the loginForm again
            return "/login";
        }
        //if the username and password match dispaly user page
        return "userPage";
    }
}


