package Lesson_4_Arrays2D;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Пример:
        //48,72,13,14,15
        //21,22,53,24,75
        //31,57,33,34,35
        //41,95,43,44,45
        //59,52,53,54,55
        //61,69,63,64,65
        //Изход:
        //най-малко 13;
        //най-голямо 95

        System.out.println("How many Cells do you need for First array.");
        int firstArr = sc.nextInt();
        while (firstArr<=0){
            System.out.println("Enter number bigger than 0.");
            firstArr = sc.nextInt();
        }
        System.out.println("How many Cells do you need for second 2D array.");
        int secArr2D = sc.nextInt();
        while (secArr2D<=0){
            System.out.println("Enter number bigger than 0.");
            secArr2D = sc.nextInt();
        }

        int[][] matrix = new int[firstArr][secArr2D];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.println("Enter value for Column " + (i+1)+ " at cell:" + (j+1));
                matrix[i][j] = sc.nextInt();
            }
        }

        int smallerNum = matrix[0][0];
        int biggerNum = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > biggerNum) {
                    biggerNum = matrix[i][j];
                }
                if (matrix[i][j] < smallerNum){
                    smallerNum = matrix[i][j];
                }
            }
        }

        System.out.println("Smallest number is : " + smallerNum);
        System.out.println("Biggest number is : " + biggerNum);
    }
}
