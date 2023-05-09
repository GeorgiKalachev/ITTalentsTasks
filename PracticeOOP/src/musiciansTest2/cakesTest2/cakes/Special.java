package musiciansTest2.cakesTest2.cakes;

import musiciansTest2.Util;

public class Special extends Cake{
    private String eventName;


    public Special( double price, int pieces) {
        super("Special Cake", price, pieces, CakeType.SPECIAL);
        this.eventName = Util.getRandomEventName();
    }

    @Override
    public int compareTo(Cake o) {
        return 0;
    }
}
