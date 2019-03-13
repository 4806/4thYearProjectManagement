package app.models;

import java.util.ArrayList;

public class Supervisor extends User {
    //List of projects supervised by this supervisor
    private ArrayList<Project> projects;

    public Supervisor(String username, String password, ArrayList<Project> projects) {
        super(username, password, "supervisor");
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
