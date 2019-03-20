package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    protected enum Role {
        STUDENT, SUPERVISOR, COORDINATOR
    }

    private Role role;

    private String confPassword;


    private String answerTosecurityQuestion;

    public User(){}

    public User(String username, String password, String confPassword,
                Role role) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
    }
    public User(String username, String password, String confPassword,
                Role role, String answerTosecurityQuestion) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
        this.answerTosecurityQuestion = answerTosecurityQuestion;
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
    public String getAnswerTosecurityQuestion() {
        return answerTosecurityQuestion;
    }

    public void setAnswerTosecurityQuestion(String answerTosecurityQuestion) {
        this.answerTosecurityQuestion = answerTosecurityQuestion;
    }

}