package app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Supervisor extends User implements Serializable {
    //List of projects supervised by this supervisor
    private ArrayList<Project> projects;

    public Supervisor(String username, String password, String confPassword, ArrayList<Project> projects) {
        super(username, password, confPassword, Role.SUPERVISOR);
        this.projects = projects;
    }

    public Supervisor(String username, String password, String confPassword){
        super(username, password, confPassword, Role.SUPERVISOR);
        this.projects = new ArrayList<Project>();
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supervisor)) return false;
        if (!super.equals(o)) return false;
        Supervisor that = (Supervisor) o;
        return Objects.equals(projects, that.projects);
    }
}
