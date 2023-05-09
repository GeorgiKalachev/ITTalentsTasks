package test2.prezidenti.candidats;

public class Showmen extends Candidat{


    public Showmen(String name, EDUCATION education, double money) {
        super(name, education, money);
        this.isMoshenik = false;
    }

    @Override
    protected boolean isValidEducation(EDUCATION educ) {
        if( education == EDUCATION.NoEDUC || education == EDUCATION.OSNOVNO || educ == EDUCATION.VISHE){
            return true;
        }
        this.education = EDUCATION.NoEDUC;
        return false;
    }
}
