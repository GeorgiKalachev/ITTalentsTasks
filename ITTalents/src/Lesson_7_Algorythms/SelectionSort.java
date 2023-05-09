package Lesson_7_Algorythms;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        // selection sort
        int[] arr = new int[]{1, 4, 5, 2, 8, 3, 6, 9, 7};

        /* a[0] to a[n-1] is the array to sort */

// advance the position through the entire array
// (could do j < n-1 because single element is also min element)
        int start = 0;
        int end = arr.length-1;
        // обхождаме масива и си пазим до къде сме сортирали в началото и в края.
        for (int sortedCount = 0; sortedCount < arr.length/2; sortedCount++) {
            //ще пазим позиции на най-голям и най-малък елемент като допускаме че са в началото
            int maxIndex = start;
            int minIndex = start;

            for ( int i = start; i <= end; i++) {
                /* if this element is less, then it is the new minimum */
                if (arr[i] < arr[minIndex]) {
                    /* found new minimum; remember its index */
                    minIndex = i;
                }
                if ( arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }
            }
            // разменяме като слагаме най-големия на текущата последна позиция
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[end];
            arr[end] = temp;
            // ако в края е бил най малкия коригираме Индекс на мин тъй като вече сме го преместили
            // там където е бил най-големия
            if ( minIndex == end){
                minIndex = maxIndex;
            }
            // слагаме най-малкия на текуща начална позиция
            temp = arr[minIndex];
            arr[minIndex] = arr[start];
            arr[start] = temp;


            end--;
            start++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
