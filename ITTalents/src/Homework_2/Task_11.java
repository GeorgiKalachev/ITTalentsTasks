package Homework_2;

import java.util.Scanner;

public class Task_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // първи цикъл за редове
        for (int i = 0; i < n; i++) {
            //втори цикъл за разстояние
            for (int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            // трети цикъл за брой звезди на ред
            for (int h = 0; h <= i; h++) {
                System.out.print("* ");
            }


            System.out.println();
        }
    }
}

