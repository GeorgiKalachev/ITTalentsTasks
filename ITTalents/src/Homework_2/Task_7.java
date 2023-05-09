package Homework_2;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int n = sc.nextInt();

        int start = 3;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                System.out.println(start);

            } else {
                System.out.print(start + ",");
            }
            start += 3;
        }

    }
}
