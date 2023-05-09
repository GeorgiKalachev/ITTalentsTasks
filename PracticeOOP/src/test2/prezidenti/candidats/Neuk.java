package test2.prezidenti.candidats;

import java.util.Set;

public class Neuk extends Glasopodavatel{


    public Neuk(String name, char gender, String city, Candidat candidat, boolean isKupen) {
        super(name, gender, city, candidat, isKupen);
        this.chanceForVote = 90;
        this.chanceToMistake = 40;
    }

    @Override
    public Candidat getCandidat(Set<Candidat> candidats) {
        return this.candidat;
    }



}
