package test2.prezidenti.candidats;

import java.util.Objects;
import java.util.Random;
import java.util.Set;

public abstract class Glasopodavatel {

    private String name;
    private char gender;
    private String city;
    protected Candidat candidat;
    private boolean isKupen;
    protected int chanceForVote;
    protected int chanceToMistake;
    private int id;

    public Glasopodavatel(String name, char gender, String city, Candidat candidat, boolean isKupen) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.candidat = candidat;
        this.isKupen = isKupen;
        this.id = Candidat.unicID++;
    }

    public int getChanceToMistake() {
        return chanceToMistake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glasopodavatel that = (Glasopodavatel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }



    public boolean isGoingToVote(){

        int chance = new Random().nextInt(100);
        return this.chanceForVote > chance;
    }

    public abstract Candidat getCandidat(Set<Candidat> candidats) ;

    public boolean isKupen() {
        return isKupen;
    }
}
