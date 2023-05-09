package Homework_1;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number A :");
        double a = sc.nextDouble();
        System.out.println("Enter number B :");
        double b = sc.nextDouble();
        System.out.println("Enter number C :");
        double c = sc.nextDouble();

        if (c > a && c < b || c < a && c > b) {
            System.out.printf("The number %.1f is between %.1f and %.1f", c, a, b);
        } else {
            System.out.printf("The number %.1f is not between %.1f and %.1f", c, a, b);
        }
    }
}
