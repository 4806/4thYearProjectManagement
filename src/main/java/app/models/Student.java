package app.models;

public class Student extends User {
    //Program this Student belongs to
    private Program program;

    public Student(String username, String password,String confPassword, Program program) {
        super(username, password,confPassword, Role.STUDENT);
        this.program = program;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
