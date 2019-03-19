package app.controllers;

import app.models.User;
import app.models.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class ForgetPasswardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String dispalyforgotPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "forgotPassword");
        return "layout";
    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processPasswordForm(@ModelAttribute User user, Model model ){
        String  username = user.getUsername();
        System.out.print(username);
         User DBuser = userRepository.findByUsername(username);
         if (DBuser ==null) {
             // user do not have an account
             return "redirect:";
         }
         // ToDO: check the user 's answer for the security question
        // if(DBuser.getAnswerToSecurityQuestion().equals(user.getAnswerToSecurityQuestion())){
             //return "redirect:reset";
        // }
        return "redirect:reset";
    }

    @RequestMapping(value ="/reset",method = RequestMethod.GET)
    public String dispalyresetPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "resetPassword");
        return "layout";
    }
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public String processResetPasswordForm(@ModelAttribute User user){
        if(user.getPassword().equals(user.getConfPassword())){
            userRepository.save(user);
            return "redirect:login";
        }
        return "redirect:login";
    }

}
