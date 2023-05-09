package snowWhiteHomework.characters;

import snowWhiteHomework.places.Forest;
import snowWhiteHomework.places.Place;

public class Snowhite extends Person {

    public Snowhite(Place homplace) {
        super("Snowwhite", 0, 0, homplace);
        System.out.println("Snowhite is daughter in law of the Queeen.");
    }

    @Override
    public void growUp() {
        super.growUp();
    }

    @Override
    public int getBeautyScale() {
        if (this.getAge() >= 7) {

            return 10;
        } else {
            return super.getBeautyScale();
        }
    }

    @Override
    protected void runningInForest() {
        System.out.println("Snowhite runs in the forest.. but found a new home, and gets in.");
        this.getHomePlace().userLeave(this);
        Place forest = new Forest("The forest");
        this.foundingNewHome(forest);
    }


    public void foundingNewHome(Place place) {
        this.setHomePlace(place);
        place.setUsers(this);
    }
}

