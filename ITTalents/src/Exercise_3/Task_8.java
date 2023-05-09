package Exercise_3;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Write a program that reads a number and prints a triangle of stars with the height of
        // * the number.

        int n = sc.nextInt();

        // първи цикъл за редове
        for (int rows = 0; rows < n; rows++) {
            //втори цикъл за разстояние
            for (int empty = n - rows; empty > 1; empty--) {
                System.out.print(" ");
            }
            // трети цикъл за брой звезди на ред
            for (int star = 0; star < (2*rows -1); star++) {
                System.out.print("*");
            }


            System.out.println();

        }
    }
}
