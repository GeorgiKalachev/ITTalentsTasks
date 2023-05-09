package Lesson_7_Algorythms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        // bubble sort
        int[] arr = new int[]{1, 4, 5, 2, 8, 3, 6, 9, 7};

        for (int times = 0; times < arr.length; times++) {
            boolean hasSwap = false;
            for (int j = 1; j < arr.length-times ; j++) {
                if (arr[j-1] > arr[j]){

                    int swap = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = swap;
                    hasSwap = true;
                }
            }
            if (!hasSwap){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
