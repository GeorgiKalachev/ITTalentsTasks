package Homework_1;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three numbers :");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        num1--;
        num2--;
        num3--;

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
}
