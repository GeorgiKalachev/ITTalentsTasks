package Homework14;

import java.util.Random;

public class Util {

    public static final String[] NAMES = {"Pesho", "Kosio", "Gosho", "Sashka", "Petya", "Dino", "Franko", "Django"};

    public static String getRandomName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    public static int getRandomAge() {
        return new Random().nextInt(15, 30);
    }

    public static boolean getGender() {
        return new Random().nextBoolean();
    }
}
