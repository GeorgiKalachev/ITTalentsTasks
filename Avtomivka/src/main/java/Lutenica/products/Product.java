package Lutenica.products;

public abstract class Product {

    protected int timeToCook;
    private String name;

    public Product(String name,int timeToCook){
        this.name = name;
        this.timeToCook = timeToCook;
    }

    public int getTimeToCook() {
        return timeToCook;
    }

    public String getName() {
        return name;
    }
}
