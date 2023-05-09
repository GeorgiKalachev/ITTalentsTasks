package test2.archeri.archers;

import test2.archeri.Club;
import test2.archeri.bows.Bow;

import java.util.Objects;

public abstract class Archer {

    public enum Gender { MALE, FEMALE }

    private int clubId;
    private String name;
    private Gender gender;
    private int age;
    private Bow bow;
    private int exp;
    private int tournaments = 0;
    private ArcherType type;
    private int tens;
    private int misses;

    public Archer(String name, Gender gender, int age, Bow bow, int exp,ArcherType type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bow = bow;
        this.exp = exp;
        this.type = type;
        this.clubId = Club.uniqueId++;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archer archer = (Archer) o;
        return clubId == archer.clubId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId);
    }

    public void incrementTournament() {
        this.tournaments++;
    }

    //template method
    public int shoot(){
        int totalScore = 0;
        for (int i = 0; i < getMaxArrows(); i++) {
            int score = getRandomScore();
            score += bow.getBonuses();
            score = Math.min(10, score);
            if(score == 10){
                tens++;
            }
            if(score == 0){
                misses++;
            }
            totalScore += score;
        }
        return totalScore;
    }

    public abstract int getMaxArrows();
    protected abstract int getRandomScore();

    public ArcherType getType() {
        return type;
    }

    public int getTens() {
        return tens;
    }

    public void resetTens(){
        this.tens = 0;
    }

    public int getMisses() {
        return misses;
    }

    public void resetMisses(){
        this.tens = 0;
    }

    public Gender getGender() {
        return gender;
    }

    public Bow getBow() {
        return bow;
    }

    public int getExp() {
        return exp;
    }
}
