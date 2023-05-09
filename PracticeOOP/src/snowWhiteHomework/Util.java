package snowWhiteHomework;

import java.util.Random;


public class Util {

    private static final String[] DWARF_NAMES = {"Gimli", "Renly", "Frodo", "Drogo", "Sam", "Kerchi", "Minochi"};

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt(min, max + 1);
    }

    public static String getRandomString(String[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }

    public static String getRandomDwarfName() {
        return getRandomString(DWARF_NAMES);
    }
}
