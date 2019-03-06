package app.controllers;

import app.models.User;
import app.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model, @CookieValue(name="username", defaultValue = "noUserCookie") String username, HttpServletRequest request) {

        if(username.equals("noUserCookie")){
            model.addAttribute("user", new User());
            return "registration";
        }
        else{
//            String referer = request.getHeader("Referer");
            return "redirect:";
        }

    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        User temp = userRepository.findByUsername(user.getUsername());

        if(temp == null){
            if(user.getPassword().equals(user.getConfPassword())){
                userRepository.save(user);
                return "redirect:login";
            }
            else{
                return "registration";
            }

        }
        else{
            return "registration";
        }


    }
}