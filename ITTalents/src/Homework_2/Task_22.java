package Homework_2;

import java.util.Scanner;

public class Task_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1;
        int nextNum = num + 1;

        while (count <= 10) {

            if (nextNum % 2 == 0 || nextNum % 3 == 0 || nextNum % 5 == 0) {
                System.out.println(count + ":" + nextNum);
                count++;
            }

            nextNum++;
        }
    }
}
