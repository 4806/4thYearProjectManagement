package app.controllers;

import app.models.*;
import app.models.Program.Acronym;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(project);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        Project temp = projectRepository.findByName(project.getName());
        ArrayList<Project> projects= new ArrayList<Project>();

        if (temp == null){
            if (project.getSupervisor()==null){
                project.setSupervisor(new Supervisor(user.getUsername(),user.getPassword(),user.getConfPassword(),projects));
            }

            if (project.getStudents() == null){
                project.setStudents(new ArrayList<User>());
            }

            if (project.getRestrictionsProgram() == null){
                int size=project.getRestrictions().size();
                ArrayList<Program> programArrayList = new ArrayList<Program>();
                for (int i=0;i<size;i++){
                   String item =project.getRestrictions().get(i);
                   switch (item){
                       case "SOFT":
                           Program soft = new Program(Acronym.SOFT.getValue(),Acronym.SOFT);
                           programArrayList.add(soft);
                           break;
                       case "MECH":
                           Program mech = new Program(Acronym.MECH.getValue(),Acronym.MECH);
                           programArrayList.add(mech);
                           break;
                       case "CIVE":
                           Program cive = new Program(Acronym.CIV.getValue(),Acronym.CIV);
                           programArrayList.add(cive);
                           break;
                       case "COMP":
                           Program comp = new Program(Acronym.COMP.getValue(),Acronym.COMP);
                           programArrayList.add(comp);
                           break;
                       case "AERO":
                           Program aero = new Program(Acronym.AERO.getValue(),Acronym.AERO);
                           programArrayList.add(aero);
                           break;
                       case "ARCH":
                           Program arch = new Program(Acronym.ARCH.getValue(),Acronym.ARCH);
                           programArrayList.add(arch);
                           break;
                       case "COMM":
                           Program comm = new Program(Acronym.COMM.getValue(),Acronym.COMM);
                           programArrayList.add(comm);
                           break;
                       case "SREE":
                           Program sree = new Program(Acronym.SREE.getValue(),Acronym.SREE);
                           programArrayList.add(sree);
                           break;
                   }
                }
                project.setRestrictionsProgram(programArrayList);
//
            }

            project.activate();
            projectRepository.save(project);
            return "redirect:projects";
        }else{
            model.addAttribute("view","createProjects");
            return "layout";
        }

    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
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
