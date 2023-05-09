package snowWhiteHomework.characters;

import snowWhiteHomework.IReaction;

public class DarkKnight extends Person {

    private final Person nachalnik;


    public DarkKnight(Person shef) {
        super("The Dark Knight", 30, 2, shef.getHomePlace());
        this.nachalnik = shef;
    }


    public void takingPersonToKILL(Person person) {

        // малко реакции да тренирам
        IReaction kill = () -> {
            System.out.println("I killed you " + person.getName());
            person.killed();
        };
        IReaction pitty = () -> {
            System.out.println(" -- I pitty you. Run in the forest" + person.getName());
            person.runningInForest();
        };

        if (person.getBeautyScale() > nachalnik.getBeautyScale()) {
            System.out.println("The knight had feelings and let snowhite being alive ! ");
            pitty.reaction();
        } else {
            kill.reaction();
        }
    }


}
