package lamqtaSpaska.creatures;

public class CrazyBastard extends Bastard{
    public CrazyBastard(String name) {
        super(name);
        this.maxHealth = 300;
        this.health = maxHealth;
        this.damage = 50;
        this.armor = 35;
        this.dodgeChance = 30;
        this.dropChance = 100;
        this.goldChance = 40;
    }
}
