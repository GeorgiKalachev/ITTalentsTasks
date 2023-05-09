package test2.farm;

import java.util.List;
import java.util.Random;

public class Util {

    public static String getRandomName(){
        List<String> names = List.of("Kiro", "Misho", "Joro");
        return names.get(new Random().nextInt(names.size()));
    }

    public static String getRandomTea(){
        List<String> names = List.of("Cheren", "Laika", "Zelen");
        return names.get(new Random().nextInt(names.size()));
    }
}
