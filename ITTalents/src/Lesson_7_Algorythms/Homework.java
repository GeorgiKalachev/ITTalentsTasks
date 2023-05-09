package Lesson_7_Algorythms;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {

        int[] arr = {1,8,3,7,4,6,5};
        //find max
        //swap with first

           int min = 0;
        for (int times = 0; times < arr.length/2; times++) {
            int max = arr[0];
            int maxIdx = 0;

            int minIdx = 0;
            for (int i = 1; i < arr.length-times ; i++) {
                if (arr[i] > max){
                    max = arr[i];
                    maxIdx = i;
                }
                if (arr[i] < min){
                    min = arr[i];
                    minIdx = i;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[arr.length-times-1];
            arr[arr.length-times-1] = temp;

            int temp2 = arr[minIdx];
            arr[minIdx] = arr[min];
            arr[min++] = temp2;
        }

        System.out.println(Arrays.toString(arr));
    }
}
