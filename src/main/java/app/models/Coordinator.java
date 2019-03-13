package app.models;

import java.util.ArrayList;

public class Coordinator extends User {
    private ArrayList<Program> programs;

    public Coordinator(String username, String password, ArrayList<Program> programs) {
        super(username, password, Role.COORDINATOR);
        this.programs = programs;
    }

    public ArrayList<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(ArrayList<Program> programs) {
        this.programs = programs;
    }
}
