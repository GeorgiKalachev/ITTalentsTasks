package Homework_1;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        a = a - b;
        b = a + b;
        a = b - a;

        System.out.println("We swap them and the first value is " + a + " and second value is " + b);
    }
}
