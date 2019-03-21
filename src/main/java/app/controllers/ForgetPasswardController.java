
package app.controllers;

import app.models.User;

import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.Db2CallMetaDataProvider;
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

    private User resetUser;

    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String dispalyforgotPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "forgotPassword");
        return "layout";
    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processPasswordForm(@ModelAttribute User user, Model model ){
        String  username = user.getUsername();
        resetUser= userRepository.findByUsername(username);

        if (resetUser ==null) {
             // user do not have an account  usernameError
            model.addAttribute("view", "forgotPassword");
            model.addAttribute("usernameError", true);
             return "layout";
        }
         // ToDO: check the user 's answer for the security question
        if(resetUser.getAnswerTosecurityQuestion().equals(user.getAnswerTosecurityQuestion())){
             return "redirect:reset";
        }else {
            model.addAttribute("view", "forgotPassword");
            model.addAttribute("answerError", true);
            return "layout";
        }
        //return "redirect:login";
    }

    @RequestMapping(value ="/reset",method = RequestMethod.GET)
    public String dispalyresetPasswordForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("view", "resetPassword");
        return "layout";
    }
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public String processResetPasswordForm(@ModelAttribute User user, Model model){

        if(user.getPassword().equals(user.getConfPassword())){
            resetUser.setPassword(passwordEncoder.encode(user.getPassword()));
            resetUser.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
            userRepository.save(resetUser);
            model.addAttribute("view", "login");
            model.addAttribute("resetSuccess", true);
            return "layout";
       }else {
            model.addAttribute("view", "resetPassword");
            model.addAttribute("pwError", true);
            return "layout";
        }

    }

}
