package Lesson_4_Arrays2D;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int rows;


        do {
            System.out.println("How many Row and Columns  do you need for matrix?\n" +
                    " Enter number bigger than 0.");
            rows = sc.nextInt();
        } while (rows <= 0);


        int[][] numbers = new int[rows][rows];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println("Enter value for Column " + (i + 1) + " at cell:" + (j + 1));
                numbers[i][j] = sc.nextInt();
            }
        }
        //Имате предварително въведени стойности на елементи в двумерен
        //масив - естествени числа.
        //Да се състави програма, чрез която се извеждат стойностите на
        //елементите в двумерен масив след обръщането му на +90 градуса.

        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers[i].length-1; j >= 0; j--) {
                System.out.print((j==0)? numbers[j][i] : numbers[j][i] + ",");
                }
            System.out.println();
            }

        }

    }

