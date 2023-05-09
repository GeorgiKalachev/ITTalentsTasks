package musiciansTest2.cakesTest2.cakes;

import java.util.Random;

public class StandartCake extends Cake{

    private boolean isSyropped;

    public StandartCake( double price, int pieces) {
        super("Standart Cake", price, pieces, CakeType.STANDART);
        this.isSyropped = new Random().nextBoolean();
    }


    @Override
    public int compareTo(Cake o) {
        return 0;
    }
}
