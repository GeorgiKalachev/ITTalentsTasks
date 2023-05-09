package Lesson_3_Arrays;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        System.out.println(Integer.toBinaryString(num));

        int[] numbers = new int[num];
        for (int i = 0; i < numbers.length ; i++) {
            System.out.println("enter value for cell :" + (i+1));
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
