package app.models;

import java.io.Serializable;
import java.util.Objects;

public class Student extends User implements Serializable {
    //Program this Student belongs to
    private Program program;

    public Student(String username, String password, String confPassword, Program program) {
        super(username, password, confPassword, Role.STUDENT);
        this.program = program;
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
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(program, student.program);
    }

}
