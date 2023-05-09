package booksTest3.reads;

import java.time.LocalDate;
import java.util.Random;

public class SchoolBook extends Readable{

    public enum THEME {
        HISTORY,MATH,PROGRAMING,PHYSIC,LANGUAGE,BIOLOGY;
         static THEME randomTheme() {
            THEME[] theme = values();
            return theme[new Random().nextInt(theme.length)];
        }
    }

    private THEME theme;
    public SchoolBook(String name, LocalDate datePublished, String izdatelstvo) {
        super(name, datePublished, izdatelstvo,TYPE.SCHOOLBOOK,3,1);
        this.theme = THEME.randomTheme();
    }


    @Override
    protected THEME getTheme() {
        return this.theme;
    }

    @Override
    public void getInfo() {

        System.out.println(this.getName() + " - " + this.theme );
    }

    @Override
    public int compareTo(Readable o) {
        if(this.theme == o.getTheme()){
            return 1;
        }
        return this.theme.compareTo(o.getTheme());
    }
}
