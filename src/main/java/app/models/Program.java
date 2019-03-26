package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Acronym acronym;

    public enum Acronym {
        SOFT("Software Engineering"),
        MECH("Mechanical Engineering"),
        CIV("Civil Engineering"),
        COMP("Computer Systems Engineering"),
        AERO("Aerospace Engineering"),
        ARCH("Architectural Engineering"),
        COMM("Communications Engineering"),
        SREE("Sustainable and Renewable Energy Engineering");

        public String getValue() {
            return value;
        }

        private final String value;

        Acronym(String value){
        this.value=value;
        }

    }

    public Program(String name, Acronym acronym) {
        this.name = name;
        this.acronym = acronym;
    }

    public Program() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Acronym getAcronym() {
        return acronym;
    }

    public void setAcronym(Acronym acronym) {
        this.acronym = acronym;
    }
}
