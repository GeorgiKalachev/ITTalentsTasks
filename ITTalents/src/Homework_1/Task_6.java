package Homework_1;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three digits :");
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();

        int b = a1;
        a1 = a2;
        a2 = a3;
        a3 = b;

        System.out.println("First = second = " + a1);
        System.out.println("Second = third = " + a2);
        System.out.println("Third = first = " + a3);


    }
}
