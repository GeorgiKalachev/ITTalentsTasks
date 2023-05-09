package Homework_2;

import java.util.Scanner;

public class Task_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number :");
        int n = sc.nextInt();
        int sum = 0;
        int start = 1;

        do {
            sum += start;
            start++;
        } while (start <= n);

        System.out.println(sum);
    }
}
