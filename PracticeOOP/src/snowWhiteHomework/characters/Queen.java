package snowWhiteHomework.characters;

import snowWhiteHomework.Mirror;
import snowWhiteHomework.places.Place;
import snowWhiteHomework.PoisonedApple;

public class Queen extends Person {

    private final Mirror mirror;
    private final Snowhite daughterInLaw;
    private final DarkKnight hunter;

    public Queen(Place homePlace) {
        super("The Queeen", 25, 9, homePlace);
        this.mirror = new Mirror(this);
        this.daughterInLaw = new Snowhite(homePlace);
        this.hunter = new DarkKnight(this);
    }

    public void askingTheMirror() {
        System.out.println("Mirror mirror.. who is the most beautiful in the world ?");
        if (!mirror.tellingTheTruth()) {
            if (daughterInLaw.getHomePlace().equals(this.getHomePlace())) {
                sendingHunterToKillSnowWhite();
            } else {
                goingToKillSnowwhiteWithApple();
            }
        }
    }

    public Snowhite getDaughterInLaw() {
        return daughterInLaw;
    }

    private void goingToKillSnowwhiteWithApple() {
        setBeautyScale(1);
        System.out.println("The Queen gets VERY ANGRY.. Change outfit to ugly grandMa");
        PoisonedApple apple = new PoisonedApple();
        System.out.println("Make a poisoned apple and go to find Snowwhite to give it to her.");
        System.out.println("Give the apple to her , and make her eat it.");
        daughterInLaw.eat(apple);
        System.out.println(daughterInLaw.getName() + " eats the apple and dies.");

    }

    public void sendingHunterToKillSnowWhite() {
        System.out.println("The Queen gets very angry and Send the Knight to kill snowwhite.");
        hunter.takingPersonToKILL(daughterInLaw);
    }
}
