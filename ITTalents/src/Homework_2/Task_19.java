package Homework_2;

import java.util.Scanner;

public class Task_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        while (num != 1) {
            int nextNum;

            if (num % 2 == 0) {
                nextNum = num / 2;
            } else {
                nextNum = (num * 3) + 1;
            }
            System.out.println(nextNum);

            num = nextNum;
        }

    }
}
