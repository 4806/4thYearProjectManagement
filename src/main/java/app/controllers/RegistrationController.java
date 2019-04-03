package app.controllers;

import app.models.Program;
import app.models.Program.*;
import app.models.User;
import app.repositories.ProgramRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return "redirect:";
        }
        model.addAttribute("user", new User());
        model.addAttribute("view", "registration");
        return "layout";

    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        User temp = userRepository.findByUsername(user.getUsername());

        if(temp == null){
            if(user.getPassword().equals(user.getConfPassword())){

                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setConfPassword(passwordEncoder.encode(user.getConfPassword()));
                if (user.getProgram()==null){

                    String item = user.getProgramString();
                    switch (item){
                        case "SOFT":
                            Program soft = new Program(Acronym.SOFT.getValue(), Acronym.SOFT);
                            user.setProgram(soft);
                            break;
                        case "MECH":
                            Program mech = new Program(Acronym.MECH.getValue(),Acronym.MECH);
                            user.setProgram(mech);
                            break;
                        case "CIVE":
                            Program cive = new Program(Acronym.CIV.getValue(),Acronym.CIV);
                            user.setProgram(cive);
                            break;
                        case "COMP":
                            Program comp = new Program(Acronym.COMP.getValue(),Acronym.COMP);
                            user.setProgram(comp);
                            break;
                        case "AERO":
                            Program aero = new Program(Acronym.AERO.getValue(),Acronym.AERO);
                            user.setProgram(aero);
                            break;
                        case "ARCH":
                            Program arch = new Program(Acronym.ARCH.getValue(),Acronym.ARCH);
                            user.setProgram(arch);
                            break;
                        case "COMM":
                            Program comm = new Program(Acronym.COMM.getValue(),Acronym.COMM);
                            user.setProgram(comm);
                            break;
                        case "SREE":
                            Program sree = new Program(Acronym.SREE.getValue(),Acronym.SREE);
                            user.setProgram(sree);
                            break;
                    }
                }
                userRepository.save(user);
                return "redirect:login";
            }
            else{
                model.addAttribute("view", "registration");
                model.addAttribute("pwError", true);
                return "layout";
            }

        }
        else{
            model.addAttribute("view", "registration");
            model.addAttribute("regError", true);
            return "layout";
        }


    }
}