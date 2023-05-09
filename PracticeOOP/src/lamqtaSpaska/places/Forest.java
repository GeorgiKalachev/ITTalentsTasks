package lamqtaSpaska.places;

import lamqtaSpaska.Game;
import lamqtaSpaska.creatures.BadBastard;
import lamqtaSpaska.creatures.Bastard;
import lamqtaSpaska.creatures.CrazyBastard;
import lamqtaSpaska.creatures.Hero;

import java.util.Random;

public class Forest {

    Bastard[] kopeleta = new Bastard[3];
    private int oponent = 0;

    public Forest(){
        this.kopeleta[0] = new Bastard("lesno kopele");
        this.kopeleta[1] = new BadBastard("sredno kopele");
        this.kopeleta[2] = new CrazyBastard("ludo kopele");
    }

    public int getOponent() {
        return oponent;
    }

    public Bastard[] getKopeleta() {
        return kopeleta;
    }
    public boolean digging(Hero hero){
        Random ch = new Random();
        boolean winFight = false;
        int chance = ch.nextInt(100);
        if (chance < 30){
            int chanceOponent = ch.nextInt(100);
            int op;
            if(chanceOponent < 60){
                op = 0;
            }else if (chanceOponent < 80){
                op = 1;
            }else {
                op=2;
            }
            winFight = Game.fight(hero,kopeleta[op]);
            System.out.println("You were atacked !");
            System.out.println((winFight) ? "Win " : "Lose");
            this.oponent = op;
        }else {
            int chanceGold = ch.nextInt(100);
            int reward;
            if (chanceGold < 30){
                reward = 5;
            }else if ( chanceGold < 60){
                reward = 10;
            }else if(chanceGold < 90){
                reward = 15;
            }else {
                reward = 40;
            }
            hero.findGold(reward);
            System.out.println("You found gold : " + reward);
        }

        return winFight;
        }

    public void reviveBastards() {
        for (int i = 0; i < kopeleta.length; i++) {
            kopeleta[i].revive();
        }
    }
}

