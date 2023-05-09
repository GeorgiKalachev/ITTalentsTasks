package TaskTest2.beasts;

import TaskTest2.clients.Client;

public abstract class Beast {


    protected String name;
    protected BeastType type;
    protected int age;
    protected double price;

   public abstract void entertainClient(Client client);

    public enum BeastType {AIR,WATER,EARTH}


    public Beast(String name, BeastType type, int age,double price) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public BeastType getType() {
        return type;
    }
}
