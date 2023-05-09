import java.util.Random;

public class    Fighter {
    /*
     магии
     дебелак , нинджа
     ритник други щети

     крит да не може да бъде отбягнат от противник

     шанс да намери ракия и да си вдигне живота


     */

    String name;
    int health;
    int maxHealth;
    int damage;
    int dodgeChance;
    int critChance;
    int critDMG;
    private String heal;
    Magic magic = new Magic(heal,100,150);

    public Fighter(String name, int health, int maxHealth, int damage, int dodgeChance, int critChance, int critDMG, Magic magic) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.dodgeChance = dodgeChance;
        this.critChance = critChance;
        this.critDMG = critDMG;
        this.magic = magic;
    }

    void hit(Fighter enemy) {
        int chance = new Random().nextInt(100);

        if (chance < enemy.dodgeChance) {
            System.out.println(enemy.name + " Evades The HIT! Haha haha HAHA hah HAHA hahaha");
        } else {
            int crit = new Random().nextInt(100);
            if (crit < critChance) {
                enemy.health -= critDMG;
                System.out.println(name + " Slashes " + enemy.name + " with CRITICAAAAALLLL STRIKE !!!! " + critDMG);
            } else {
                enemy.health -= damage;
                System.out.println(name + " HITS " + enemy.name + " FOR " + damage);
            }
            System.out.println(enemy.name + " Health remain : " + enemy.health);
        }
    }


    boolean isAlive() {
        return health > 0;
    }

    void revive() {
        health = maxHealth;
    }



}
