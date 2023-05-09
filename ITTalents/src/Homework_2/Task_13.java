package Homework_2;

import java.util.Scanner;

public class Task_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int num = sc.nextInt();

        System.out.println("Numbers with sum of digits equal to your number:");
        for (int i = 100; i <= 999; i++) {

            int firstDig = i / 100;
            int secDig = (i % 100) / 10;
            int thirdDIg = i % 10;

            int sumOfDigits = firstDig + secDig + thirdDIg;

            if (num == sumOfDigits) {
                System.out.println(i);
            }

        }

    }
}
