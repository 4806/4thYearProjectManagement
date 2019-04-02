package app.controllers;

import app.models.*;
import app.repositories.ProjectRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/createProject")
    public String create(Model model) {

        model.addAttribute("project",new Project());
        model.addAttribute("view", "createProject");
        return "layout";
    }

    @PostMapping("/createProject")
    public String create(@ModelAttribute Project project, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        Project temp = projectRepository.findByName(project.getName());
        if (temp == null){
            if (project.getSupervisor()==null){
                user.setProjects(new ArrayList<>());
                project.setSupervisor(user);
            }

            if (project.getStudents() == null){
                project.setStudents(new ArrayList<>());
            }

            user.getProjects().add(project);
            project.activate();
            projectRepository.save(project);
            return "redirect:projects";
        }else{
            return "redirect:createProject";
        }

    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        User supervisor = new User("Supervisor","password","password", new ArrayList<>());
        Iterable<Project> all = projectRepository.findAll();
        if(auth instanceof AnonymousAuthenticationToken || user.getRoleValue().equals("STUDENT")){
            List<Project> active = new ArrayList<>();
            for(Project project : all){
                if(project.isActive()){
                    active.add(project);
                }
            }
            model.addAttribute("project", active);
            model.addAttribute("view", "projects");
            return "layout";
        }
        else{
            model.addAttribute("project", all);
            model.addAttribute("view", "projects");
            return "layout";
        }
    }



    @PostMapping("/join")
    public String join(@ModelAttribute Project select, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        Project selected = projectRepository.findByName(select.getName());
        if(!(selected.addStudent(user))){
            model.addAttribute("addError", true);
        }
        projectRepository.save(selected);

        Iterable<Project> all = projectRepository.findAll();
        List<Project> active = new ArrayList<>();
        for(Project project : all){
            if(project.isActive()){
                active.add(project);
            }
        }
        model.addAttribute("project", active);
        model.addAttribute("view", "projects");
        return "layout";
    }

    @PostMapping("/archive")
    public String archive_project(Model model, Project oper){

        Project temp = projectRepository.findByName(oper.getName());

        temp.removeAllStudents();

        temp.deactivate();
        projectRepository.save(temp);

        return "redirect:projects";

    }

    @PostMapping("/unarchive")
    public String unarchive_project(Model model, Project oper){

        Project temp = projectRepository.findByName(oper.getName());

        temp.activate();
        projectRepository.save(temp);

        return "redirect:projects";

    }

    @PostMapping("/delete")
    public String deleteProject(Model model, Project delproj){

        Project temp = projectRepository.findByName(delproj.getName());

        projectRepository.delete(temp);

        return "redirect:projects";
    }
}
