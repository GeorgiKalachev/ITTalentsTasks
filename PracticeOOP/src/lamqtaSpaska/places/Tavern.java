package lamqtaSpaska.places;

import lamqtaSpaska.creatures.Hero;
import lamqtaSpaska.items.Item;

public class Tavern {

    private int money ;
    private int numOfSleeps;
    private final int sleepCost;

    public Tavern(String name){
        this.money = 500;
        this.numOfSleeps = 0;
        this.sleepCost = 20;
    }

    public void sleepOver(Hero hero){
        if (hero.getMoney() < sleepCost){
            System.out.println("You dont have money -- go Forest to dig, than sleep.");
            System.out.println("One sleep cost : " + sleepCost + " , you have : " + hero.getMoney());
        }else {
            hero.chargeMoney(sleepCost);
            this.money += sleepCost;
            System.out.println("Great.. now will sleeep goood. Left with : " + hero.getMoney() + " lv.");
            hero.revive();
            this.numOfSleeps++;
            hero.setSleepsInHana();
        }

    }

    public void buyItem(Item item){
        this.money -= item.getPrice();
    }





    public int getMoney() {
        return money;
    }

    public int getNumOfSleeps() {
        return numOfSleeps;
    }
}
