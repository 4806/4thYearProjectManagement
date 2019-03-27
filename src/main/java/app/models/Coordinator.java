package app.models;

import java.util.ArrayList;
import java.util.Objects;

public class Coordinator extends User {
    private ArrayList<Program> programs;

    public Coordinator(String username, String password, String confPassword, ArrayList<Program> programs) {
        super(username, password, confPassword, Role.COORDINATOR);
        this.programs = programs;
    }

    public ArrayList<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(ArrayList<Program> programs) {
        this.programs = programs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinator)) return false;
        if (!super.equals(o)) return false;
        Coordinator that = (Coordinator) o;
        return Objects.equals(programs, that.programs);
    }

}
