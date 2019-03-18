package app.models;

public class Student extends User {
    //Program this Student belongs to
    private Program program;

    public Student(String username, String password, Program program) {
        super(username, password, Role.STUDENT);
        this.program = program;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
