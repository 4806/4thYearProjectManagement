
package app.controllers;

import app.models.User;

import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class ForgetPasswardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String dispalyforgotPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "forgotPassword");
        return "layout";
    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processPasswordForm(@ModelAttribute User user, Model model ){
        String  username = user.getUsername();
        System.out.println(username);
        System.out.print(user.getAnswerTosecurityQuestion());

        User DBuser = userRepository.findByUsername(username);
       // System.out.print(DBuser.getAnswerTosecurityQuestion());

         if (DBuser ==null) {
             // user do not have an account
             return "redirect:login";
        }
         // ToDO: check the user 's answer for the security question
        if(DBuser.getAnswerTosecurityQuestion().equals(user.getAnswerTosecurityQuestion())){
             return "redirect:reset";
        }
        return "redirect:login";
    }

    @RequestMapping(value ="/reset",method = RequestMethod.GET)
    public String dispalyresetPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "resetPassword");
        return "layout";
    }
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public String processResetPasswordForm(@ModelAttribute User user){
        User DBuser = userRepository.findByUsername(user.getUsername());

        if(user.getPassword().equals(user.getConfPassword())){
            DBuser.setPassword(passwordEncoder.encode(user.getPassword()));
            DBuser.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
            userRepository.save(DBuser);
            DBuser.setPassword(user.getPassword());
            //DBuser.setConfPassword(user.getConfPassword());
            userRepository.save(DBuser);
            return "redirect:login";
       }
        return "redirect:reset";
    }

}
