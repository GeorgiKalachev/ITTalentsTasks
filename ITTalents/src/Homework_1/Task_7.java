package Homework_1;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter hour:");
        int hour = sc.nextInt();
        System.out.println("Enter amount of money:");
        double money = sc.nextDouble();
        System.out.println("Is your health good?");
        boolean isHealthyGood = sc.hasNextBoolean();

        if (isHealthyGood) {
            System.out.println("Go to cinema with friends.");
        } else {
            System.out.println("Stay at home.");
        }

        if (money > 0) {
            if (money > 10) {
                System.out.println("Buy medicament's");
            } else {
                System.out.println("Go to coffee shop.");
            }
        } else {
            System.out.println("Stay at home and drink tea.");
        }
    }
}