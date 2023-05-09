package Lesson_4_Arrays2D;

import java.util.Scanner;

public class Task5 {
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
        // Да се състави програма, при която предварително са въведени
        //естествени числа в двумерен масив 4*4 елемента.
        //Програмата да извежда резултат от проверката какво е съотношението
        //на най-голямата сума по редове спрямо най-голямата сума по колони.

        int columnsMaxSum =  numbers[0][0];
        int countColumns = 0;
        int rowsMaxSum = numbers[0][0];
        int countRows = 0;

        for (int i = 0; i < numbers.length ; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                countRows += numbers[i][j];
            }
            if(countRows > rowsMaxSum){
                rowsMaxSum = countRows;
            }
            countRows =0;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                countColumns += numbers[j][i];
                if(countColumns > columnsMaxSum){
                    columnsMaxSum = countColumns;
                }
            }
            countColumns = 0;
        }
        System.out.println("The biggest sum from rows is : " + rowsMaxSum);
        System.out.println("The biggest sum from columns is : " + columnsMaxSum);
        System.out.println("Max sum from rows is " +
                ((rowsMaxSum>columnsMaxSum)? ">":"<" )+ " from columns max sum.");

    }
}
