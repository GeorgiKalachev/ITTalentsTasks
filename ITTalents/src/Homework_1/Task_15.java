package Homework_1;

import java.util.Scanner;

public class Task_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter hour:");
        int num = sc.nextInt();

        if (num > 4 && num < 9) {
            System.out.println("Good morning.");
        } else if (num >= 9 && num <= 18) {
            System.out.println("Good day.");
        } else if (num > 18 && num < 24 || num >= 0 && num <= 4) {
            System.out.println("Good evening.");
        }else {
            System.out.println("You have enter wrong hour.");
        }
    }
}
