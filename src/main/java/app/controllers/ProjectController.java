package app.controllers;

import app.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @GetMapping("/request")
    public String request(Model model) {

        model.addAttribute("view", "request");
        return "layout";
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {

        //projectRepository.save(new Project("Title Project","Description Project",5,null,null,null));
        List<Project> arrayList = AddProjects();
        model.addAttribute("project", arrayList);
        model.addAttribute("view", "projects");
        return "layout";
    }

    private List<Project> AddProjects() {
        List<Project> list = new ArrayList<Project>();
        list.add(new Project("Title Project", "Description Project", 5, null, null, null));
        list.add(new Project("Title Project", "Description Project", 9, null, null, null));
        list.add(new Project("Title Project", "Description Project", 65, null, null, null));
        return list;
    }

}
