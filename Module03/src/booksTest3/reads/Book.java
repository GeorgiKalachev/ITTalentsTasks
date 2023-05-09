package booksTest3.reads;

import java.time.LocalDate;
import java.util.Random;

public class Book extends Readable {

    public enum JANR {
        LOVE, ROMAN, TRILLER, ACTION, COMEDY;

        public static JANR randomJanr() {
            JANR[] janrs = values();
            return janrs[new Random().nextInt(janrs.length)];
        }
    }

    private String autor;
    private JANR janr;


    public Book(String name, LocalDate datePublished, String izdatelstvo, String autor) {
        super(name, datePublished, izdatelstvo,TYPE.BOOK,2,3);
        this.autor = autor;
        this.janr = JANR.randomJanr();
    }
}
