package streamsCollections;

import java.util.HashSet;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {


        HashSet<Present> presents = new HashSet<>();

        presents.add(new Present("DOLL",15.0));
        presents.add(new Present("TRAIN",25.0));
        presents.add(new Present("DOLL",155.0));
        presents.add(new Present("TRAIN",23.0));
        presents.add(new Present("CAR",20.0));

        for (Present present : presents )
        { System.out.print("[ "+ present.getName() + " - " + present.getAge() + " ]"); }
    }
}
