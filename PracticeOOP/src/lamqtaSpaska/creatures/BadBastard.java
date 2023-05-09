package lamqtaSpaska.creatures;


public class BadBastard extends Bastard{


    public BadBastard(String name) {
        super( name);
        this.maxHealth = 150;
        this.health = maxHealth;
        this.damage = 45;
        this.armor = 20;
        this.dodgeChance = 0;
        this.dropChance = 90;
        this.goldChance = 10;
    }


}
