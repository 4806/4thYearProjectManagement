package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController{
    @RequestMapping("/")
    public String LandingPage() {
        return "index";
    }
}
