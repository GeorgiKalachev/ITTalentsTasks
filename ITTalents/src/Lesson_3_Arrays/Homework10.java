package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която се въвеждат 7 цели числа в
        //едномерен масив.
        //Програмата да изведе числото, което е най-близко до средната
        //стойност на въведените числа.
        //Пример: 1,2,3,4,5,6,7
        //Изход: средна стойност 4, най-близка стойност 4

        System.out.println("You have to enter 7 numbers !");

        int[] firstArr = new int[7];

        int sum = 0;
        for (int i = 0; i < firstArr.length; i++) {
            System.out.println("Enter value for cell :" + (i + 1));
            firstArr[i] = sc.nextInt();
            sum += firstArr[i];
        }
        int middleSum = sum / firstArr.length;
        // така ще проверя кое е по голямото число в случай на отрицателно число.
        int diffNum = (middleSum > firstArr[0]) ? middleSum - firstArr[0] : firstArr[0] - middleSum;
        int targetNum = firstArr[0];

        //  1 2 3 4 5 6 7 8 9
        for (int i = 1; i < firstArr.length; i++) {
            int currDiff = (middleSum > firstArr[i]) ? middleSum - firstArr[i] : firstArr[i] - middleSum;
            if (currDiff < diffNum) {
                diffNum = currDiff;
                targetNum = firstArr[i];
            }
        }


        System.out.println("Average value of array : " + middleSum);
        System.out.println("Minimal different value is number : " + targetNum);
    }
}


