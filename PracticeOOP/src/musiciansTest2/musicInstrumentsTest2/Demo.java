package musiciansTest2.musicInstrumentsTest2;

import musiciansTest2.Util;
import musiciansTest2.musicInstrumentsTest2.instruments.Elektronen;


public class Demo {

    public static void main(String[] args) {

        Elektronen klavir = new Elektronen("elkata",35, Util.getRandomElekKind());

        Shop shop = new Shop();

        shop.addInstrumen(klavir);

        shop.printAll();

        shop.getInstrumentsForSale(Util.getRandomDuhovKind(),5);

        shop.printAll();

    }
}
