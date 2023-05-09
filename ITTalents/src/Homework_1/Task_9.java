package Homework_1;

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int numOne = sc.nextInt();
        int numTwo = sc.nextInt();

        int multiply = numOne*numTwo;
        int lastNum = multiply % 10;

        if (lastNum % 2 == 0){
            System.out.println(multiply + ", " + lastNum + " even number");
        }else {
            System.out.println(multiply + ", " + lastNum + " odd number");
        }



    }
}
