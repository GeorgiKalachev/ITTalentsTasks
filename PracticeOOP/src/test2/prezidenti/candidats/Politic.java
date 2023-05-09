package test2.prezidenti.candidats;

import java.util.Random;

public class Politic extends Candidat{


    public Politic(String name, EDUCATION education, double money) {
        super(name, education, money);
        this.isMoshenik = new Random().nextBoolean();
    }

    @Override
    protected boolean isValidEducation(EDUCATION education) {
        if( education == EDUCATION.SREDNO || education == EDUCATION.VISHE ){
            return true;
        }
        this.education = EDUCATION.SREDNO;
        return false;
    }
}
