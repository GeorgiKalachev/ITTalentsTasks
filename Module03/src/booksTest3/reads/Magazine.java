package booksTest3.reads;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

public class Magazine extends Readable{

    public enum CATEGORY {
        MODE,CARS,MANAGER,COOKING,SPORT,STOCK;
         static CATEGORY randomCat() {
            CATEGORY[] cats = values();
            return cats[new Random().nextInt(cats.length)];
        }}
    private CATEGORY category;
    private int numOfCounts;



    public Magazine(String name, LocalDate datePublished, String izdatelstvo) {
        super(name, datePublished, izdatelstvo,TYPE.MAGAZINE,1,1);
        this.category = CATEGORY.randomCat();
        this.numOfCounts = new Random().nextInt(5,55);
    }

    @Override
    public void getInfo() {

        System.out.println(this.getName() + " - " + this.category );
    }

    @Override
    protected CATEGORY getCategory() {
        return this.category;
    }

    @Override
    public int compareTo(Readable o) {
        if(this.category == o.getCategory()){
            return 1;
        }
        return this.category.compareTo(o.getCategory());
    }
}
