package snowwhite.presents;

import snowwhite.Kid;

public abstract class Present {

    public enum PresentType { DOLL, CLOTHING, CAR, BOOK, TRAIN }

    private String color;
    private double price;
    private Kid kid;


    public Present(double price, Kid kid){
        this.price = price >= getMinPrice() && price <= getMaxPrice() ? price :  (getMaxPrice() + getMinPrice() )/ 2;
        this.kid = kid;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    protected abstract double getMinPrice();
    protected abstract double getMaxPrice();
}
