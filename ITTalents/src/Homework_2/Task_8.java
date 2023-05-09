package Homework_2;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number 'n' :");
        int n = sc.nextInt();

        int startMinusOne = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(startMinusOne);
            }
            startMinusOne += 2;
            System.out.println();
        }
    }
}
