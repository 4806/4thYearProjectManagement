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
    private ArrayList<String>  restrictions;

    @Column(length=1024)
    private ArrayList<Program>  restrictionsProgram;


    //Status of the project
    private enum Status {ACTIVE, INACTIVE}
    private Status status;

    public Project() {

    }

    public Project(String name, String description, int numberStudents, Supervisor supervisor, ArrayList<User> students, ArrayList<Program>  restrictionsProgram) {
        this.name = name;
        this.description = description;
        this.numberStudents = numberStudents;
        this.supervisor = supervisor;
        this.students = students;
        this.restrictionsProgram = restrictionsProgram;
        this.status = Status.ACTIVE;
    }

    public ArrayList<Program> getRestrictionsProgram() {
        return restrictionsProgram;
    }

    public void setRestrictionsProgram(ArrayList<Program> restrictionsProgram) {
        this.restrictionsProgram = restrictionsProgram;
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

    public ArrayList<String>  getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<String>  restrictions) {
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


    public boolean addStudent(User student){
        if(this.getNumberStudents() == this.students.size()){
            return false;
        }
        for (User s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                return false;
            }
        }
        this.students.add(student);
        return true;
    }

    public void activate(){
        this.status = Status.ACTIVE;
    }

    public void deactivate(){
        this.status = Status.INACTIVE;
    }

    public boolean isActive(){
        return this.status == Status.ACTIVE;
    }

    public void removeAllStudents() {
        if(!this.getStudents().isEmpty()){
            this.getStudents().clear();
        }
    }

}

