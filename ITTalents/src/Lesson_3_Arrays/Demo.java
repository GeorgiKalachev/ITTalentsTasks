package Lesson_3_Arrays;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        int x = 5;
        int[] array = new int[5]; // 5 variables of type int
        // <type> <name> = <value>
        char[] symbol = new char[10];
        double[] doubles = new double[40];

        array[0] = 4;
        array[1]++;
        array[2] = array[0] + array[1];

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        int[] ages = {15,20,25,30,35};

        for (int i = 0; i < ages.length ; i++) {
            System.out.println(ages[i]);
        }

        System.out.println(ages[1]);

        System.out.println(Arrays.toString(ages));
    }
}
