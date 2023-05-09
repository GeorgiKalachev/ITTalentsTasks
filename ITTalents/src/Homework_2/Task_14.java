package Homework_2;

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = n; i > 0; i--) {
            if (i % 7 == 0) {
                System.out.println(i);
            }

        }
    }

}
