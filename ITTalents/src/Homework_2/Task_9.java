package Homework_2;

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = 0;

        for (int i = num1; i <= num2; i++) {
            int currentNum = i * i;

            if (currentNum % 3 == 0) {
                System.out.print("skip 3,");
            } else {
                System.out.print(currentNum + ",");
                sum += currentNum;
            }

            if (sum >= 200) {
                break;
            }

        }
    }
}
