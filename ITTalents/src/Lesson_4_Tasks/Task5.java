package Lesson_4_Tasks;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows;
        int columns;

        do {
            System.out.println("How many ROWS do you need? Enter number bigger than 0.");
            rows = sc.nextInt();
        } while (rows <= 0);
        do {
            System.out.println("How many COLUMNS do you need? Enter number bigger than 0.");
            columns = sc.nextInt();
        } while (columns <= 0);

        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println("Enter value for Column " + (i + 1) + " at cell:" + (j + 1));
                numbers[i][j] = sc.nextInt();
            }
        }


        int countRows = numbers[0][0];
        int count = 0;
        int biggestRow = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                count += numbers[i][j];
            }
            if (count > countRows) {
                countRows = count;
                biggestRow = i;
            }
            count = 0;
        }
        System.out.println("The biggest sum from rows is : " + countRows + " on row : " + biggestRow);

    }
}
