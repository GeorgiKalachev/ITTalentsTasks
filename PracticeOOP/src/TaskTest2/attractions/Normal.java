package TaskTest2.attractions;

import TaskTest2.beasts.Beast;

public class Normal extends Atraction{


    public Normal(String name, Beast beast) {
        super(name, beast);
        this.chanceToKill = 0;
    }
}
