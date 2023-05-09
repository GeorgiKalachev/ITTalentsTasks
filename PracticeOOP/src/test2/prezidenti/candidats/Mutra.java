package test2.prezidenti.candidats;

import java.util.Random;

public class Mutra extends Candidat{



    public Mutra(String name, EDUCATION education, double money) {
        super(name, education, money);
        this.isMoshenik = true;
    }

    @Override
    protected boolean isValidEducation(EDUCATION education) {
       if( education == EDUCATION.NoEDUC || education == EDUCATION.OSNOVNO ){
           return true;
       }
       this.education = EDUCATION.NoEDUC;
       return false;
    }

}
