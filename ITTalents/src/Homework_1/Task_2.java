package Homework_1;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two integer numbers :");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        int subtract = num1 - num2;
        int multiply = num1 * num2;
        int divide = num1 / num2;
        int divideRemain = num1 % num2;

        System.out.println("Their sum :"+ sum);
        System.out.println("Their subtract :"+ subtract);
        System.out.println("Their multiply :"+ multiply);
        System.out.println("Their divide :"+ divide);
        System.out.println("Their remain with divide :"+ divideRemain);

        System.out.println("Now enter two double numbers :");

        double numOne = sc.nextDouble();
        double numTwo = sc.nextDouble();
        // Защо ми дава грешка ако вкарам числото с '.' пример : 12.5
        // не дава грешка ако е със запетая пример : 12,5

        System.out.println("Their sum :"+ (numOne + numTwo));
        System.out.println("Their subtract :"+ (numOne - numTwo));
        System.out.println("Their multiply :"+ (numOne * numTwo));
        System.out.println("Their divide :"+ (numOne / numTwo));
        System.out.println("Their remain with divide :"+ (numOne % numTwo));

    }
}
