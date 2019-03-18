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
public String request(Model model){

        model.addAttribute("view", "request");
        return "layout";
}
@GetMapping("/projects")
public String listProjects(Model model){
    List<Project> arrayList = new ArrayList<Project>(){{
        add(new Project("Title Project","Description Project",5,null,null,null));
        add(new Project("Title Project","Description Project",9,null,null,null));
        add(new Project("Title Project","Description Project",65,null,null,null));
    }};
    //projectRepository.save(new Project("Title Project","Description Project",5,null,null,null));

    model.addAttribute("project",arrayList);
        model.addAttribute("view","projects");
        return "layout";
}

}
