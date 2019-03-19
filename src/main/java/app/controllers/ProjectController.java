package app.controllers;

import app.models.Program;
import app.models.Project;
import app.models.Student;
import app.models.Supervisor;
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
        List<Project> arrayList = addProjectStubMethod();
        model.addAttribute("project", arrayList);
        model.addAttribute("view", "projects");
        return "layout";
    }

    private List<Project> addProjectStubMethod() {

        Supervisor supervisor = new Supervisor("Babak Esfandiari", "Password",new ArrayList<Project>(){{
            add(new Project("Title Project", "Description Project", 5, null, null, null));
        }});
        ArrayList<Student> studentArrayList = new ArrayList<Student>(){{
            add(new Student("Jacob Marshland","",null));
            add(new Student("Jerry Burburaz","",null));
        }};

        ArrayList<Program> programArrayList = new ArrayList<Program>(){{
            add(new Program("Software Engineering", Program.Acronym.SOFT));
            add(new Program("Computer Systems Engineering", Program.Acronym.COMP));
        }};

        List<Project> list = new ArrayList<Project>();
        list.add(new Project("Title Project", "Description Project", 4, supervisor, null, null));
        list.add(new Project("Title Project", "Description Project", 2, null, studentArrayList, null));
        list.add(new Project("Title Project", "Description Project", 65, null, null, programArrayList));
        return list;
    }

}
