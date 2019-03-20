package app.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //Maximum Number of students
    private int numberStudents;

    // Increased Column Size due to serialized objects
    @Column(length=1024)
    private Supervisor supervisor;

    //Current Students participating in Project
    @Column(length=1024)
    private ArrayList<User> students;

    //Required Program for Students Participating
    @Column(length=1024)
    private ArrayList<Program> restrictions;

    //Status of the project
    private enum Status {ACTIVE, INACTIVE}
    private Status status;

    public Project() {

    }

    public Project(String name, String description, int numberStudents, Supervisor supervisor, ArrayList<User> students, ArrayList<Program> restrictions) {
        this.name = name;
        this.description = description;
        this.numberStudents = numberStudents;
        this.supervisor = supervisor;
        this.students = students;
        this.restrictions = restrictions;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    public ArrayList<Program> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<Program> restrictions) {
        this.restrictions = restrictions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void addStudent(User student){
        for (User s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                return;
            }
        }
        this.students.add(student);
    }
}

