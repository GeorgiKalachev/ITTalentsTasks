package Lesson_4_Arrays2D;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Имате двумерен масив от числа, чийто стойности са въведени
        //предварително. Да се отпечатат сумата на елементите на масива,
        //както и средноаритметичното на тези числа.
        int rows;
        int columns;

        do{
            System.out.println("How many ROWS do you need? Enter number bigger than 0.");
            rows = sc.nextInt();
        }while (rows <=0);
        do{
            System.out.println("How many COLUMNS do you need? Enter number bigger than 0.");
            columns = sc.nextInt();
        }while (columns <=0);

        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <numbers[i].length ; j++) {
                System.out.println("Enter value for Column " + (i+1)+ " at cell:" + (j+1));
                numbers[i][j] = sc.nextInt();
            }
        }


        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length ; j++) {
                    sum += numbers[i][j];
            }
        }

        System.out.println("The sum of all numbers is : " + sum );
        System.out.println("The average value is : " + sum / (rows*columns) );
    }
    }
