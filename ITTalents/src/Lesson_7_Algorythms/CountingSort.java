package Lesson_7_Algorythms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 4,1,-5,-2,2,3,4,4,2,1,6,7, 5, 2, 8, 3, 6, 9, 7};

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if ( max < arr[i]){
                max = arr[i];
            }
            if ( min > arr[i]){
                min = arr[i];
            }
        }
        // намерихме най-голямото число
        // и си правим помощен масив +1 клетки
        int[] helper = new int[max-min+1];

        for (int i = 0; i < arr.length; i++) {
            helper[arr[i] - min]++;
            //увеличаваме стойността на arr[i] в helper[arr[i]]
            //                           4   увеличава helper[4]
        }

        int index = 0;
        for (int i = 0; i < helper.length; i++) {
            int counted = i + min;
            int counter = helper[i];

            for (int j = 0; j < counter; j++) {
                arr[index++] = counted;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
    
}
