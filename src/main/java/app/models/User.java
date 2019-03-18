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
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min=1, max=50)
    private String password;

    protected enum Role {
        STUDENT, SUPERVISOR, COORDINATOR
    }

    @Column(name = "role")
    private Role role;

    @Column(name = "confPassword")
    private String confPassword;

    public User(){}

    public User(@Size(min = 2, max = 30, message = "Username size should be in the range [2...30]") String username, @NotNull @Size(min = 1, max = 50) String password, Role role) {
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
