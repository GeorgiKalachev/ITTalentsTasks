package Homework_1;

import java.util.Scanner;

public class Task_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a three digit number:");
        int number = sc.nextInt();


        int firstDig = number / 100;
        int secDig = (number % 100) / 10;
        int thirdDig = number % 10;

        if (number % firstDig == 0 && number % secDig == 0 && number % thirdDig == 0){
            System.out.println("Your number can be divide by each digit.");
        }else {
            System.out.println("Your number can NOT be divide by each digit.");
        }


    }
}
