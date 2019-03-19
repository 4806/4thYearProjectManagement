package app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user", schema = "projectmanagement")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    protected enum Role {
        STUDENT, SUPERVISOR, COORDINATOR
    }

    @Column(name = "role")
    private Role role;

    @Column(name = "confPassword")
    private String confPassword;

    public User(){}

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
}
