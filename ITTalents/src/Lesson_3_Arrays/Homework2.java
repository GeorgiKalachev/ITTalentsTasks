package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Нека по въведен масив да се конструира нов, като половината му
        //елементи са точно като на оригиналния, а другите да са тези
        //елементи, но в обратен ред. Последно, да се изведе новия масив
        //на екрана.
        int num;
        do{
            System.out.println("How many cells do you need? Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num <=0);
        int[] numbers = new int[num];
        int[] mirrorNums = new int[num*2];

        for (int i = 0; i < numbers.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            numbers[i] = sc.nextInt();
        }


        for (int i = 0; i < numbers.length; i++) {
            mirrorNums[i] = numbers[i];

            System.out.print(mirrorNums[i] + " ");
        }
        for (int i = numbers.length-1; i >= 0 ; i--) {
            mirrorNums[num] = numbers[i];

            System.out.print(mirrorNums[num++] + " ");
        }

        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < mirrorNums.length; i++) {
            System.out.print((i == mirrorNums.length-1) ? mirrorNums[i] : mirrorNums[i] + ", ");
        }
        System.out.print(" ]");


    }
}
