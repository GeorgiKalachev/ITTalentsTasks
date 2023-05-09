package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("How many cells do you need? Enter min 3.");
        int num = sc.nextInt();

        while (num<3){
            System.out.println("Enter number bigger than 3");
            num= sc.nextInt();
        }

        double[] arrayNum = new double[num];

        for (int i = 0; i < arrayNum.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            arrayNum[i] = sc.nextDouble();
        }
        //Да се състави програма, която въвежда в едномерен масив реални
        //числа.
        //Като изход: програма извежда онези 3 различни числа, чиято
        //абсолютна стойност формира максималната обща сума.
        //Пример: 7.13; 0.2; 4.9; 5.1; 6.34; 1.12
        //Изход: 5.1; 6.34; 7.13

        double firstNum = arrayNum[0];
        double secNum =arrayNum[1];
        double thirdNum =arrayNum[2];

        for (int i = 3; i < arrayNum.length; i++) {

            if (arrayNum[i] > firstNum){
                thirdNum = secNum;
                secNum = firstNum;
                firstNum = arrayNum[i];
            }else if (arrayNum[i] > secNum){
                thirdNum = secNum;
                secNum = arrayNum[i];
            } else if (arrayNum[i]> thirdNum) {
                thirdNum = arrayNum[i];
            }


        }

        System.out.println("The three numbers with biggest sum are:");
        System.out.printf("[ %.2f; %.2f; %.2f ]",firstNum,secNum,thirdNum);


    }
}
