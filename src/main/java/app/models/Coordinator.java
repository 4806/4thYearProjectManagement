package app.models;

import java.util.ArrayList;

public class Coordinator extends User {
    private ArrayList<Program> programs;

    public Coordinator(String username, String password, ArrayList<Program> programs) {
        super(username, password, "coordinator");
        this.programs = programs;
    }
}
