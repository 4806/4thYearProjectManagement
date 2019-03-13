package app.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Acronym acronym;

    private enum Acronym {
        SOFT,
        MECH,
        CIV,
        COMP,
        OTHER
    }

    public Program(String name, Acronym acronym) {
        this.name = name;
        this.acronym = acronym;
    }

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
