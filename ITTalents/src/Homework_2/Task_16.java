package Homework_2;

import java.util.Scanner;

public class Task_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int smallNum;
        int bigNum;

        // проверявам по-голямото число
        if (a > b) {
            bigNum = a;
            smallNum = b;
        } else {
            bigNum = b;
            smallNum = a;
        }

        for (int i = bigNum; i >= smallNum; i--) {
            if (i % 50 == 0) {
                System.out.print(i + ", ");
            }
        }

    }
}
