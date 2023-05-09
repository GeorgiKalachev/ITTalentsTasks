package Homework_2;

import java.util.Scanner;

public class Task_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 1;
        int count = 1;

        do{
            sum *= count;

            count++;
            n--;
        }while (n != 0);

        System.out.println(sum);
    }
}
