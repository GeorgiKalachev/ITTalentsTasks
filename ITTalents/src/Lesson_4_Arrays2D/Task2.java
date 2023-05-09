package Lesson_4_Arrays2D;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        //Имате квадратен двумерен масив от естествени числа, чийто стойности
        //се въвеждат от конзолата. Да се отпечатат диагоналите на масива.
        //Пример:
        //1,4,6,3
        //5,9,7,2
        //4,8,1,9
        //2,3,4,5
        //Изход:
        //1 9 1 5
        //3 7 8 2
        System.out.println("How many Cells do you need for square matrix.");
        int num = sc.nextInt();
        while (num<=0){
            System.out.println("Enter number bigger than 0.");
            num = sc.nextInt();
        }


        int[][] matrix = new int[num][num];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.println("Enter value for Column " + (i+1)+ " at cell:" + (j+1));
                matrix[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j || j == num-1){
                    System.out.print(matrix[i][j] + " ");
                }else {
                    System.out.print("  ");
                }
            }
            num--;
            System.out.println();
        }

    }
}
