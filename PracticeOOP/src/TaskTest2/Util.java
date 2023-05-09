package TaskTest2;

import java.util.Random;

public class Util {

    private static final String[] NAMES = {"Gosho","Pesho","Tisho","Krisi","Tanq","Alex","Vayne","Sasho","Sisi"};




    public static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }
}
