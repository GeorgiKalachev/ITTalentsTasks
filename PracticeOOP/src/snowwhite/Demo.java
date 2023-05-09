package snowwhite;

import snowwhite.presents.Car;

public class Demo {

    public static void main(String[] args) {

        Factory factory = new Factory("ITTalents Gifts OOD");
        for (int i = 0; i < 15; i++) {
            Dwarf dwarf = new Dwarf(Util.getRandomDwarfName(), Util.getRandomInt(100, 150));
            factory.hireDwarf(dwarf);
        }
        SnowWhite snowWhite = new SnowWhite();
        factory.hireSnowWhite(snowWhite);

        for (int i = 0; i < 100; i++) {
            Kid kid = new Kid(Util.getRandomDwarfName(), Util.getRandomCity(), Util.getRandomInt(1, 100) < 40, factory);
        }

        snowWhite.distributeWork();
        snowWhite.prepareSleigh();
        snowWhite.prepareReports();
    }
}
