package main.cleaning.clothes;

import java.util.Random;

public abstract class Clothing {

    private int id;
    private int timeToClean;
    private double price;

    public static final String[] CLOTHING_TYPES = {"Shirt", "Pants", "Jacket", "Hat"};

    public Clothing(String name, int timeToClean, double price) {
        //TODO validate
        this.id = generateId(name);
        this.timeToClean = timeToClean;
        this.price = price;
        System.out.println(name + " created with timeToClean " + timeToClean);
    }

    private int generateId(String name){
        for (int i = 0; i < CLOTHING_TYPES.length; i++) {
            if(CLOTHING_TYPES[i].equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static Clothing getRandomCloth() {
        int chance = new Random().nextInt(CLOTHING_TYPES.length);
        return switch (chance){
            case 0 -> new Shirt();
            case 1 -> new Pants();
            case 2 -> new Jacket();
            default -> new Hat();
        };
    }

    public int getId() {
        return id;
    }

    public int getTimeToClean() {
        return timeToClean;
    }

    public double getPrice() {
        return price;
    }
}
