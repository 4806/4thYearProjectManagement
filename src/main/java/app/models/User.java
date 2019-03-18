package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;
    @NotNull
    @Size(min=1, max=50)
    private String password;
    private String role;
    private String confPassword;

    private String answerToSecurityQuestion;

    public User(){}

    public User(@Size(min = 2, max = 30, message = "Username size should be in the range [2...30]") String username, @NotNull @Size(min = 1, max = 50) String password,
                String role, String answerToSecurityQuestion) {
        this.username = username;
        this.password = password;
        this.confPassword = confPassword;
        this.role = role;
        this.answerToSecurityQuestion= answerToSecurityQuestion;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String pw){
        this.confPassword = pw;
    }

    public String getAnswerToSecurityQuestion() {
        return answerToSecurityQuestion;
    }

    public void setAnswerToSecurityQuestion(String answerToSecurityQuestion) {
        this.answerToSecurityQuestion = answerToSecurityQuestion;
    }
}
