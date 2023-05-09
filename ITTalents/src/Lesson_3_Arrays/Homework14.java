package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do{
            System.out.println("How many cells do you need? Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num <=0);
        double[] firstArr = new double[num];

        for (int i = 0; i < firstArr.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            firstArr[i] = sc.nextDouble();
        }
        //Имате предварително въведен едномерен масив, съдържащ реални
        //числа.
        //Да се състави програма, чрез която се избират само елементи от
        //масива със стойности от интервала [-2.99..2.99] и се отпечатват в нов
        //масив. Новият масив да се извежда на екрана.
        //Пример: 7.1,8.5,0.2,3.7,0.99,1.4,-3.5,-110,212,341,1.2
        //Изход: 0.2; 0.99; 1.4; 1.2

        int countTargetNums = 0;
        for (int i = 0; i < firstArr.length; i++) {
            if(firstArr[i] > -3.0 && firstArr[i] < 3.0){
                countTargetNums++;
            }
        }
        // създаваме нов масив и отново обхождаме стария.
        double[] newArray = new double[countTargetNums];
        int startNewArray = 0;
        for (int i = 0; i < firstArr.length; i++) {
            if(firstArr[i] > -3.0 && firstArr[i] < 3.0){
                newArray[startNewArray++] = firstArr[i];
            }
        }

        System.out.println("The new array has " + countTargetNums + " elements.");
        System.out.print("[ ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print((i==newArray.length-1) ? newArray[i] : newArray[i] + "; ");
        }
        System.out.print(" ]");

    }
}
