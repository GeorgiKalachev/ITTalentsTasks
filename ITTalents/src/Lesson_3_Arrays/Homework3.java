package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се въведе число, след което да се създаде масив с 10
        //елемента по следния начин:
        //Първите 2 елемента на масива са въведеното число.
        //Всеки следващ елемент на масива е равен на сбора от
        //предишните 2 елемента в масива.
        //След това изведете масива .

        System.out.println("Enter number:");
        int num = sc.nextInt();
        int[] numArr = new int[10];

        numArr[0] = num;
        numArr[1] = num;
        for (int i = 2; i < numArr.length ; i++) {
            numArr[i] = numArr[i-1] + numArr[i-2];
        }

        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < numArr.length; i++) {
            System.out.print((i == numArr.length-1) ? numArr[i] : numArr[i] + ", ");
        }
        System.out.print(" ]");

    }
}
