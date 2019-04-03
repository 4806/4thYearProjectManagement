package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public User(){}

    public User(String username, String password, String confPassword, Role role) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
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

    public List<String> getAvailability() {
        return availability;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(program, user.program) &&
                Objects.equals(projects, user.projects) &&
                role == user.role &&
                Objects.equals(confPassword, user.confPassword) &&
                Objects.equals(availability, user.availability);
    }

}
