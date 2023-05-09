package Lesson_7_Algorythms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 4, 5, 2,20,14,6,50,30,33,34,23,34,76,15,23, 8, 3, 6, 9, 7};

        /* създаваме Pivot  рандом число
          - разделяме на части / по малки от Пивот / Пивот / по големи от Пивот
          - сортираме / partition
         */

        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    static int partition(int[] masiv,int start,int end){
        int pivot = masiv[end];
        // check and compare with pivot
        // if yes -> swap left from it
        int leftMostIdx = start;

        for (int i = start; i < end; i++) {
            if ( masiv[i] < pivot){
                int swap = masiv[i];
                masiv[i] = masiv[leftMostIdx];
                masiv[leftMostIdx] = swap;
                leftMostIdx++;
            }
        }
        int temp = masiv[end];
        masiv[end] = masiv[leftMostIdx];
        masiv[leftMostIdx] = temp;

        return leftMostIdx;
    }
    static void sort(int[] masiv,int start,int end){
        if ( start >= end){
            return;
        }
        int pivotIndx = partition(masiv,start,end);
        sort(masiv,start,pivotIndx-1);
        sort(masiv,pivotIndx+1,end);

    }
}
