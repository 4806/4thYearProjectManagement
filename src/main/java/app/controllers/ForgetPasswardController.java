
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
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class ForgetPasswardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private User resetUser;

    @RequestMapping(value = "/forgot",method = RequestMethod.GET)
    public String dispalyforgotPasswordForm(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:";
        }
        // dispaly forgot password form
        model.addAttribute("user", new User());
        model.addAttribute("view", "forgotPassword");
        return "layout";
    }

    @RequestMapping(value = "/forgot",method = RequestMethod.POST)
    public String processPasswordForm(@ModelAttribute User user, Model model ){
        String  username = user.getUsername();
        resetUser= userRepository.findByUsername(username);
        // if  no account with username  provided exists print username error message
        if (resetUser ==null) {
            model.addAttribute("view", "forgotPassword");
            // error message will be dsiplayed when wrong username is provided
            model.addAttribute("usernameError", true);
             return "layout";
        }
        // when the user name is valid check the answer to security question
        // if correct allow the user to reset their password otherwise rturn an error message
        if(resetUser.getAnswerTosecurityQuestion().equals(user.getAnswerTosecurityQuestion())){
            if(user.getPassword().equals(user.getConfPassword())){
                resetUser.setPassword(passwordEncoder.encode(user.getPassword()));
                resetUser.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
                userRepository.save(resetUser);
                model.addAttribute("view", "login");
                model.addAttribute("resetSuccess", true);
                return "layout";
            }else {
                // if password do not match return an error message.
                model.addAttribute("view", "forgotPassword");
                model.addAttribute("pwError", true);
                return "layout";
            }
        }else {
            model.addAttribute("view", "forgotPassword");
            // error message when answer to security question is wrong
            model.addAttribute("answerError", true);
            return "layout";
        }

    }

}
