package musiciansTest2.cakesTest2.cakes;

import musiciansTest2.cakesTest2.cakes.Cake;
import musiciansTest2.cakesTest2.cakes.persons.Client;
import musiciansTest2.cakesTest2.cakes.persons.Deliver;
import java.util.ArrayList;

public class Order {

    private Client client;
    private double price;
    private String addresFor;
    private Deliver deliver;
    // spisyk s torti
    private ArrayList<Cake> cakes;
    private int deliverHour;



    public Order(Client client) {
        this.client = client;
        this.cakes = new ArrayList<>();
        this.addresFor = client.getAdress();
        this.deliverHour = 1;
    }


    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }

    public   void setDiscount(double discount){
        this.price = discount;

    }

    public double getPrice() {
        return price;
    }

    public double setPrice() {
        double price = 0;
        for (Cake cake : cakes) {
            price += cake.getPrice();
        }
        this.price = price;
        return price;
    }

    public void setCakes(Cake cake) {
        this.cakes.add(cake);
    }


    public Deliver getDeliver() {
        return this.deliver;
    }
}
