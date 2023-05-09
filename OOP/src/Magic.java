import java.util.Random;

public class Magic {

    String name;
    int magicDMG;
    int magicCritDMG;

    public Magic(String name, int magicDMG, int magicCritDMG) {
        this.name = name;
        this.magicDMG = magicDMG;
        this.magicCritDMG = magicCritDMG;
    }

    void magicHeal(Fighter figh1){

                figh1.health += 100;
                System.out.println("hahah " + figh1.name + " heal him with 100 ( 30% chance ) bellow 100 health.");


    }
    void magicHit(Fighter enemy) {
        int chance = new Random().nextInt(100);

        if (chance < enemy.dodgeChance) {
            System.out.println(enemy.name + " Evades The Magic HIT! Haha haha HAHA hah HAHA hahaha");
        } else {
            int crit = new Random().nextInt(100);
            if (crit < magicCritDMG) {
                enemy.health -= magicCritDMG;
                System.out.println(name + " Slashes " + enemy.name + " with MAGICAL crit STRIKE !!!! " + magicCritDMG);
            } else {
                enemy.health -= magicDMG;
                System.out.println(name + " HITS " + enemy.name + " with" + magicDMG + "MAGIIIIIC dmggggg");
            }
            System.out.println(enemy.name + " Health remain : " + enemy.health);
        }
    }


}
