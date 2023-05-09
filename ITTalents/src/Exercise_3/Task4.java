package Exercise_3;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

        int max = rows * columns;
        int[] allElements = new int[max];
        for (int i = 0; i < allElements.length ; i++) {

        }
    }

}
