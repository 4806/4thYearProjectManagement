package app.controllers;

import app.models.*;
import app.repositories.ProjectRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProjectRepository projectRepository;

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
                project.setSupervisor(new Supervisor(user.getUsername(),user.getPassword(),user.getConfPassword(),null));
            }


            projectRepository.save(project);
            return "redirect:projects";
        }else{
            model.addAttribute("view","createProjects");
            return "layout";
        }

    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        //projectRepository.save(new Project("Title Project","Description Project",5,null,null,null));
        //List<Project> arrayList = addProjectStubMethod();
//        addProjectStubMethod();
        model.addAttribute("project", projectRepository.findAll());
        model.addAttribute("view", "projects");
        model.addAttribute("select", new Project());
        return "layout";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Project select, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());

        //todo: use select.getName() in project repo to get the project

        //Need to fetch list of projects from project repo
        model.addAttribute("project", select);
        model.addAttribute("select", new Project());
        model.addAttribute("view", "projects");
        return "layout";
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
        Project project = new Project("Title Project 1", "Description for Project 1", 4, supervisor, null, null);
        Project project1 = new Project("Title Project 2", "Description for Project 2", 2, null, studentArrayList, null);
        Project project2 = new Project("Title Project 3", "Description for Project 3", 65, null, null, programArrayList);

        List<Project> list = new ArrayList<Project>();
        list.add(project);
        list.add(project1);
        list.add(project2);
        return list;
    }
//    private void addProjectStubMethod() {
//        //program stub
//        Program program = new Program("Software Engineering", Program.Acronym.SOFT);
//        Program program1 =new Program("Computer Systems Engineering", Program.Acronym.COMP);
//        ArrayList<Program> programArrayList = new ArrayList<Program>();
//        programArrayList.add(program);
//        programArrayList.add(program1);
//
//        // Students stubs
//        Student student = new Student("Jacob Marshland","","",null);
//        Student student1 = new Student("Jerry Burburaz","","",null);
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//        studentArrayList.add(student);
//        studentArrayList.add(student1);
//
//        //project stub
//        Project project3 = new Project("Title Project", "Description Project", 5, null, null, null);
//        ArrayList<Project> projectArrayList = new ArrayList<Project>();
//        projectArrayList.add(project3);
//
//        //supervisor stub
//        Supervisor supervisor = new Supervisor("Babak Esfandiari", "Password", "Password",null);
//
//        //projects for list
//        Project project = new Project("Title Project", "Description Project", 4, supervisor, null, null);
//        Project project1 = new Project("Titl", "Description Project", 2, null, studentArrayList, null);
//        Project project2 = new Project("Tvdect", "Description Project", 65, null, null, programArrayList);
//
//          projectRepository.save(project);
//          projectRepository.save(project1);
//        projectRepository.save(project2);
//        projectRepository.save(project);
//        projectRepository.save(project1);
//        projectRepository.save(project2);
//        projectRepository.save(project);
//        projectRepository.save(project1);
//        projectRepository.save(project2);
//        projectRepository.save(project);
//        projectRepository.save(project1);
//        projectRepository.save(project2);
//    }

}
