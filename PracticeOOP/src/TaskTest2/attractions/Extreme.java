package TaskTest2.attractions;

import TaskTest2.beasts.Beast;
import TaskTest2.clients.Client;

public class Extreme extends Atraction{


    public Extreme(String name, Beast beast) {
        super(name, beast);
        this.chanceToKill = 10;
    }


}
