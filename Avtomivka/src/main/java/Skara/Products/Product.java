package Skara.Products;

import java.util.Random;

public abstract class Product {

    public static Product getRandomMeat() {
        int chance = new Random().nextInt(3);
        switch (chance) {
            case 0 -> {
                return new Kiofte();
            }
            case 1 -> {
                return new Pleskavica();
            }
            default -> {
                return new Parjola();
            }
        }
    }

    public static Product getRandomBread() {
        int chance = new Random().nextInt(2);
        switch (chance) {
            case 0 -> {
                return new BqloHlebche();
            }
            default -> {
                return new ChernoHlebche();
            }
        }
    }

    public static Product getRandomSalad() {
        int chance = new Random().nextInt(5);
        switch (chance) {
            case 0 -> {
                return new DomatiKrastavici();
            }
            case 1 -> {
                return new Lutenica();
            }
            case 2 -> {
                return new RuskaSalata();
            }
            case 3 -> {
                return new Snejanka();
            }
            default -> {
                return new ZeleMorkovi();
            }
        }
    }


    public enum PRODUCT_TYPE {MEAT, SALAD, HLEB}

    ;
    private PRODUCT_TYPE type;
    protected String productType;
    private int id;
    private String name;
    private int timeToCook;
    private double price;

    public Product(PRODUCT_TYPE type, String productType, int timeToCook, double price) {
        this.type = type;
        this.productType = productType;
        this.name = getClass().getSimpleName();
        this.timeToCook = timeToCook;
        this.price = price;
    }

    public long getTimeToCook() {
        return timeToCook;
    }

    public PRODUCT_TYPE getType() {
        return type;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
