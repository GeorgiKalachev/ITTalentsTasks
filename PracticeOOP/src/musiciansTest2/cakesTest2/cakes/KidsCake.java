package musiciansTest2.cakesTest2.cakes;

import musiciansTest2.Util;

public class KidsCake extends Cake{

    private String kidsName;


    public KidsCake(double price, int pieces) {
        super("Kids Cake",  price, pieces,CakeType.KIDSTYPE);
        this.kidsName = Util.getRandomKidName();
    }

    @Override
    public int compareTo(Cake o) {
        return 0;
    }
}
