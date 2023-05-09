package snowwhite.presents;

import snowwhite.Kid;

public class Book extends Present{

    private String title;
    private int tales;

    public Book(double price, Kid kid, String title, int tales) {
        super(price, kid);
        this.title = title;
        this.tales = tales >= 1 && tales <= 5 ? tales : 3;
    }

    @Override
    protected double getMinPrice() {
        return 10;
    }

    @Override
    protected double getMaxPrice() {
        return 20;
    }
}
