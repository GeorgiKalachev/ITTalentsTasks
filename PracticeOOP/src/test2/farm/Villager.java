package test2.farm;

import test2.farm.services.BuyService;
import test2.farm.services.PetService;
import test2.farm.services.PloughService;
import test2.farm.services.Service;

import java.util.Random;
import java.util.Set;

public class Villager {

    public static Farm farm;
    private Service service;

    public void thinkOfAService(){
        int chance = new Random().nextInt(3);
        switch (chance){
            case 0 -> this.service = new BuyService(new Random().nextBoolean() ? "milk" : "wool", new Random().nextInt(3,5));
            case 1 -> this.service = new PetService(new Random().nextBoolean() ? "cat" : "dog", new Random().nextInt(1,4));
            default -> this.service = new PloughService(new Random().nextInt(10,40));
        }
    }

    public void askFarm(){
        farm.addService(this.service);
    }

}
