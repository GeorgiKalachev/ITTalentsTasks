package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("You have to enter 7 numbers !");
        int[] firstArr = new int[7];
        for (int i = 0; i < firstArr.length; i++) {
            System.out.println("Enter value for cell :" + (i + 1));
            firstArr[i] = sc.nextInt();
        }

        //Да се състави програма, която въвежда от клавиатурата 7 цели числа
        //в едномерен масив
        //Програмата да изведе всички числа кратни на 5, но по големи от 5.
        //Пример: -23, -55, 17, 75, 56, 105, 134
        //Изход: 75,105 - 2 числа

        int count = 0;
        System.out.println("All numbers bigger than 5 and divide by 5 are :");
        System.out.print("[ ");
        for (int i = 0; i < firstArr.length; i++) {
            if ( firstArr[i] > 5 && firstArr[i] % 5 == 0){
                System.out.print(firstArr[i] + " ");
                count++;
            }
        }
        System.out.print("] - " + count + " numbers." );
    }
}
