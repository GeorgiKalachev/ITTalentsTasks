package lamqtaSpaska.creatures;

import java.util.Random;

public abstract class Creature {

    private final String name;
    protected int health;
    protected int maxHealth;
    protected int damage;
    protected int armor;
    protected int dodgeChance;

    public String getName() {
        return name;
    }

    public Creature(String name) {
        this.name = name;
    }

    protected int getHealth() {
        return health;
    }

    protected int getDamage() {
        return damage;
    }

    protected int getArmor() {
        return armor;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public void hit(Creature enemy) {
        int chance = new Random().nextInt(100);

        if (chance < enemy.dodgeChance) {
            System.out.println(enemy.name + " Evades The HIT! Haha ");
        } else {

            if (getDamage() > enemy.getArmor()) {
                enemy.setHealth(enemy.getHealth() - (getDamage() - enemy.getArmor()));
                System.out.println(name + " HITS " + enemy.name + " FOR " + (getDamage()- enemy.getArmor()));
            }else {
                System.out.println("Too much armor " + enemy.name);
            }

        }
    }


    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void revive() {
        health = maxHealth;
    }

}
