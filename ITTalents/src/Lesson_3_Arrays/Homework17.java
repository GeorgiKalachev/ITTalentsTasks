package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many cells do you need?");
        int num = sc.nextInt();

        while (num <= 1){
            System.out.println("Enter number bigger than 1:");
            num = sc.nextInt();
        }
        int[] arrayNums = new int[num];

        for (int i = 0; i < arrayNums.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            arrayNums[i] = sc.nextInt();
        }
        //Една редица от естествени числа ще наричаме зигзагообразна нагоре,
        //ако за елементите и са изпълняват условията:
        //N1 < N2 > N3 < N4 > N5 <..
        //Съставете програма, която проверява дали въведени в едномерен
        //масив редица от числа изпълняват горните изисквания.
        //Пример: 1 3 2 4 3 7
        //Изход: изпълнява изискванията за зигзагообразна нагоре редица

        boolean goingZigZag = true;
        for (int i = 1; i < arrayNums.length ; i++) {
            if(i % 2 == 1){
                if(arrayNums[i] <= arrayNums[i-1]){
                    goingZigZag = false;
                }
            }else {
                if(arrayNums[i] >= arrayNums[i-1]){
                    goingZigZag = false;
                }
            }
        }

        if(goingZigZag){
            System.out.println("The array is going in Zig Zag positive way");
        }else {
            System.out.println("Incorrect array.");
        }
    }
}
