package snowWhiteHomework.characters;

import snowWhiteHomework.places.Place;
import snowWhiteHomework.Util;

public class Dwarf extends Person {


    public Dwarf(Place place) {
        super(Util.getRandomDwarfName(), Util.getRandomInt(20, 100), Util.getRandomInt(1, 8), place);
    }


}
