package musiciansTest2.cakesTest2.cakes;

import java.util.Random;

public class WeddingCake extends Cake{

    private int floorsNum;

    public WeddingCake( double price, int pieces) {
        super("Wedding Cake", price, pieces, CakeType.WEDDING);
        this.floorsNum = new Random().nextInt(5);
    }

    @Override
    public int compareTo(Cake o) {
        return 0;
    }
}
