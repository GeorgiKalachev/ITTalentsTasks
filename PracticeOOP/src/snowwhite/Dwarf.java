package snowwhite;

import snowwhite.presents.*;

import java.util.ArrayList;
import java.util.Random;

public class Dwarf {

    private String name;
    private int height;
    private ArrayList<Present> presentsCreated = new ArrayList();
    private Factory factory;

    public Dwarf(String name, int height){
        this.name = name;
        this.height = height;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public void createPresent(Present.PresentType presentType, Kid kid){

        double price = Util.getRandomInt(2,40);
        Present present =
            switch (presentType){
                case CAR -> new Car(price, kid, Util.getRandomInt(2, 6));
                case BOOK -> new Book(price, kid, "Sweet dreams", Util.getRandomInt(3,30));
                case DOLL -> new Doll(price, kid, Util.getRandomColor(), Util.getRandomDollDimensions());
                case TRAIN -> new Train(price, kid, new Random().nextBoolean());
                default -> new Clothing(price, kid, "Silk", Util.getRandomClothesDimensions());
            };

        if(!kid.isNaughty()){
            present.setPrice(present.getPrice()*1.2);
        }
        kid.approvePresent();
        String color = Util.getRandomColor();
        present.setColor(color);
        factory.addColor(color);
        factory.addExpenses(present.getPrice());
        factory.addToStorage(present);
        this.presentsCreated.add(present);
    }

    public int getPresentsCreated(){
        return this.presentsCreated.size();
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
