package Homework_2;

import java.util.Scanner;

public class Task_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numToMultiply = sc.nextInt();
        int maxMultiplyNum = sc.nextInt();

        for (int i = 1; i <= numToMultiply; i++) {
            for (int j = 1; j <= maxMultiplyNum; j++) {
                int result = i * j;
                System.out.println(i + " * " + j + " = " + result);
            }

        }
    }
}
