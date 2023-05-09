import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Fighter hercules = new Fighter();
        hercules.name = "Hercules";
        hercules.maxHealth = 500;
        hercules.health = hercules.maxHealth;
        hercules.damage = 35;
        hercules.dodgeChance = 15;
        hercules.critChance = 10;
        hercules.critDMG = 45;
        hercules.magic.name = hercules.name + " magic";
        hercules.magic.magicDMG = 100;
        hercules.magic.magicCritDMG = 75;

        Fighter zeus = new Fighter();
        zeus.name = "Zeus";
        zeus.maxHealth = 500;
        zeus.health = zeus.maxHealth;
        zeus.damage = 35;
        zeus.dodgeChance = 15;
        zeus.critChance = 10;
        zeus.critDMG = 40;
        zeus.magic.name = zeus.name + " magic";
        zeus.magic.magicDMG = 60;
        zeus.magic.magicCritDMG = 65;

        int herculesWins = 0;
        int zeusWins = 0;

        for (int i = 0; i < 100; i++) {
            int round = 1;


            while (true) {
                System.out.println("------- ROUND + " + round++ + " ----------");

                if (new Random().nextBoolean()) {

                    if (fight(hercules, zeus)) {
                        zeusWins++;
                        break;
                    }
                    if (fight(zeus, hercules)) {
                        herculesWins++;
                        break;
                    }
                } else {
                    if (fight(zeus, hercules)) {
                        herculesWins++;
                        break;
                    }
                    if (fight(hercules, zeus)) {
                        zeusWins++;
                        break;
                    }
                }
            }
            zeus.revive();
            hercules.revive();

        }


        System.out.println("Hercules wins : " + herculesWins);
        System.out.println("Zeus wins : " + zeusWins);

    }

    static boolean fight(Fighter f1, Fighter f2) {

        if (f1.isAlive()) {
            int chance = new Random().nextInt(100);
            if (chance < 9 && f1.health < 100){
                f1.magic.magicHeal(f1);
            }
            if (chance < 30){

                f1.magic.magicHit(f2);
            }else {
                f1.hit(f2);
            }

            return false;
        } else {
            System.out.println(f2.name + "Wins");
            return true;
        }

    }
}