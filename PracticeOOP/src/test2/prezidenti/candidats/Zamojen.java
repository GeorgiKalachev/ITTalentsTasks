package test2.prezidenti.candidats;

import java.util.Random;
import java.util.Set;

public class Zamojen extends Glasopodavatel{

    public Zamojen(String name, char gender, String city, Candidat candidat, boolean isKupen) {
        super(name, gender, city, candidat, isKupen);
        this.chanceForVote = 50;
    }

    @Override
    public Candidat getCandidat(Set<Candidat> candidats) {
        int chance = new Random().nextInt(100);
        if (chance < chanceForVote){
            return this.candidat;
        }else {
            return candidats.stream().findAny().get();
        }
    }


}
