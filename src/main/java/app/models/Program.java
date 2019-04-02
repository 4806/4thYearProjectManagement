package app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 83 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Program other = (Program) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
}
