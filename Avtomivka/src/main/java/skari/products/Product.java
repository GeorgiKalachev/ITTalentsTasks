package skari.products;

import java.util.Random;

public abstract class Product {

    private double price;
    private int cookTime;

    public Product(){
        this.price = getPrice();
        this.cookTime = getCookTime();
    }

    public abstract double getPrice();
    public abstract int getCookTime();

    public static Product getRandomMeat(){
        int chance = new Random().nextInt(3);
        switch (chance){
            case 1 : return new Purjola();
            case 2 : return new Kiufte();
            default: return new Pleskavica();
        }
    }


    public static Product getRandomSalad(){
        int chance = new Random().nextInt(5);
        switch (chance){
            case 1 : return new Snejanka();
            case 2 : return new DomatiKrastavici();
            case 3 : return new RuskaSalata();
            case 4 : return new Liutenica();
            default: return new ZeleMorkovi();
        }
    }


    public static Product getRandomBread(){
        int chance = new Random().nextInt(2);
        switch (chance){
            case 1 : return new BqlHlqb();
            default: return new PulnozurnestHlqb();
        }
    }
}
