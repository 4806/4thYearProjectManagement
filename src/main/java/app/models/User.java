package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;


    public enum Role {
        STUDENT, SUPERVISOR, COORDINATOR
    }

    private Role role;

    private String confPassword;

    @Column(length=1024)
    private ArrayList<String> availability;

    public User(){}
    public User( String newPassword, String confPassword){
        this.password = newPassword;
        this.confPassword= confPassword;
    }
    public User(String username, String password, String confPassword, Role role) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleValue(){

        switch(role) {
            case STUDENT:
                return "STUDENT";
            case SUPERVISOR:
                return "SUPERVISOR";
            case COORDINATOR:
                return "COORDINATOR";
        }
        return role.name();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String pw){
        this.confPassword = pw;
    }

    public void setAvailability(ArrayList<String> availability) {
        this.availability = availability;
    }

    public ArrayList<String> getAvailability() {
        return availability;
    }

}
