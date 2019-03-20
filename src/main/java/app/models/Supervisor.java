package app.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Supervisor extends User implements Serializable {
    //List of projects supervised by this supervisor
    private ArrayList<Project> projects;

    public Supervisor(String username, String password, String confPassword, ArrayList<Project> projects) {
        super(username, password, confPassword, Role.SUPERVISOR);
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
