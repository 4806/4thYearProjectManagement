package app.controllers;

import app.models.Program;
import app.models.Project;
import app.models.Student;
import app.models.Supervisor;
import app.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/request")
    public String request(Model model) {

        model.addAttribute("view", "request");
        return "layout";
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {

        //projectRepository.save(new Project("Title Project","Description Project",5,null,null,null));
        List<Project> arrayList = addProjectStubMethod();
        model.addAttribute("oper", new Project());
        model.addAttribute("project", arrayList);
        model.addAttribute("view", "projects");
        return "layout";
    }

    @PostMapping("/archive")
    public String archive_project(Model model, Project oper){

//        Project temp = projectRepository.findByName(oper.getName());
//
//        temp.deactivate();
        if(oper.getName().equals("Title Project1")){
            return "redirect:";
        }

        return "redirect:projects";

    }

    @PostMapping("/unarchive")
    public String unarchive_project(Model model, Project oper){

//        Project temp = projectRepository.findByName(oper.getName());
//
//        temp.activate();

        if(oper.getName().equals("Title Project1")){
            return "redirect:";
        }

        return "redirect:projects";

    }


    private List<Project> addProjectStubMethod() {
        //program stub
        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
        Program program1 =new Program("Computer Systems Engineering", Program.Acronym.COMP);
        ArrayList<Program> programArrayList = new ArrayList<Program>();
        programArrayList.add(program);
        programArrayList.add(program1);

        // Students stubs
        Student student = new Student("Jacob Marshland","","",null);
        Student student1 = new Student("Jerry Burburaz","","",null);
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        studentArrayList.add(student);
        studentArrayList.add(student1);

        //project stub
        Project project3 = new Project("Title Project", "Description Project", 5, null, null, null);
        ArrayList<Project> projectArrayList = new ArrayList<Project>();
        projectArrayList.add(project3);

        //supervisor stub
        Supervisor supervisor = new Supervisor("Babak Esfandiari", "Password", "Password",projectArrayList);

        //projects for list
        Project project = new Project("Title Project1", "Description Project", 4, supervisor, null, null);
        Project project1 = new Project("Title Project2", "Description Project", 2, null, studentArrayList, null);
        Project project2 = new Project("Title Project3", "Description Project", 65, null, null, programArrayList);

        List<Project> list = new ArrayList<Project>();
        list.add(project);
//        projectRepository.save(project);
        list.add(project1);
//        projectRepository.save(project1);
        list.add(project2);
//        projectRepository.save(project2);
        return list;
    }

}
