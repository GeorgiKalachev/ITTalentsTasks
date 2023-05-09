package snowWhiteHomework.characters;

import snowWhiteHomework.IReaction;
import snowWhiteHomework.places.Place;

public class Prince extends Person {

    public Prince(Place place) {
        super("The Prince", 20, 8, place);

    }

    public void seeingPerson(Person person) {
        System.out.println("Time has go .....");
        System.out.println("The prince walked around the forest and sees " + person.getName());
        IReaction kiss = () -> {
            System.out.println("I will kiss you  " + person.getName());
            kissing(person);
        };
        IReaction goingThrou = () -> {
            System.out.println("I dont care about you " + person.getName());
        };

        if (person.getBeautyScale() > 8) {
            kiss.reaction();
        } else {
            goingThrou.reaction();
        }
    }

    private void kissing(Person person) {
        System.out.println("Mirracle happend. " + person.getName() + " alives.");
        person.revive();
        person.fallingInLove(this);
    }
}
