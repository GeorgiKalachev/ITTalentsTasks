package lamqtaSpaska.items;


public class Item {

    protected String name ;
    protected int bonusHealth = 0;
    protected int bonusDMG = 0;
    protected int bonusArmor = 0;
    protected int price = 0;

    public Item(){
        this.name = "null";
    }
    public String getName() {
        return name;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusDMG() {
        return bonusDMG;
    }

    public int getBonusArmor() {
        return bonusArmor;
    }

    public int getPrice() {
        return price;
    }

    public String showInfo(){
        return name;
    }

}
