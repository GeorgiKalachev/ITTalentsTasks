package Lesson_4_Tasks;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, която проверява дали в масив от цели
        //числа всички числа са неотрицателни.

        int num;
        do {
            System.out.println("Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num<=0);

        int[] numbers = new int[num];

        boolean isNegative = true;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number for cell : " + (i+1));
            numbers[i]= sc.nextInt();
            if (numbers[i] < 0){
                isNegative = false;
                break;
            }
        }

        if (isNegative){
            System.out.println("All positive numbers.");
        }else {
            System.out.println("You have negative number");
        }


    }
}
