package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @ManyToOne
    private Program program;

    @OneToMany(mappedBy = "supervisor")
    private List<Project> projects;

    public enum Role {
        STUDENT, SUPERVISOR, COORDINATOR
    }

    private Role role;

    private String confPassword;

    @ElementCollection
    private List<String> availability;

    // Current Project for user assuming Student
    private Project project;

    private String answerTosecurityQuestion;

    public User(){}

    public User( String newPassword, String confPassword){
        this.password = newPassword;
        this.confPassword= confPassword;
    }

    public User(String username, String password, String confPassword,
                Role role) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
    }
    public User(String username, String password, String confPassword,
                Role role, String answerTosecurityQuestion) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
        this.answerTosecurityQuestion = answerTosecurityQuestion;
    }


    //Student Constructor
    public User(String username, String password, String confPassword, Program program) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = Role.STUDENT;
        this.program = program;
    }

    //Supervisor Constructor
    public User(String username, String password, String confPassword, ArrayList<Project> projects) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = Role.SUPERVISOR;
        this.projects = projects;
    }

    //Coordinator Constructor
    public User(String username, String password, String confPassword) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = Role.COORDINATOR;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleValue(){

        switch(role) {
            case STUDENT:
                return "STUDENT";
            case SUPERVISOR:
                return "SUPERVISOR";
            case COORDINATOR:
                return "COORDINATOR";
        }
        return role.name();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String pw){
        this.confPassword = pw;
    }

    public void setAvailability(List<String> availability) {
        this.availability = availability;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void addProject(Project project) {
        if (projects != null) {
            projects.add(project);
        } else {
            projects = new ArrayList<>();
            projects.add(project);
        }
    }

    public void updateProject(Project project) {
        if (projects != null) {
            int i = 0;
            for (Project proj : projects) {
                if (proj.getName().equals(project.getName())) {
                    projects.set(i, project);
                }
                i++;
            }
        }
    }
    public String getAnswerTosecurityQuestion() {
        return answerTosecurityQuestion;
    }

    public void setAnswerTosecurityQuestion(String answerTosecurityQuestion) {
        this.answerTosecurityQuestion = answerTosecurityQuestion;
    }

    public void setAvailability(ArrayList<String> availability) {
        this.availability = availability;
    }

    public List<String> getAvailability() {
        return availability;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

}
