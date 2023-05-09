package musiciansTest2.cakesTest2.cakes.persons;

import musiciansTest2.cakesTest2.cakes.Order;

import java.util.ArrayList;

public class Deliver extends Person {

    private ArrayList<Order> orders = new ArrayList<>();
    private double tips;

    public Deliver(String name, String phoneNum) {
        super(name, phoneNum);
    }

    public void setTips(double tips){
        this.tips += tips;
    }

    public double getTips() {
        return this.tips;
    }
}
