package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която се въвежда число и се представя
        //като число в двоична бройна система.
        //Програмата, чрез масив, да изчислява последователно всички цифри
        //на въведеното естествено число в 2-ична бройна система.
        //Пример: 99
        //Изход: 1100011

        int num;
        do {
            System.out.println("Enter positive number :");
            num = sc.nextInt();
        }while (num<=0);

        int result = 0;
        int startNum = num;


            while (startNum > 0){
                result++;
                startNum = startNum / 2;
            }
            int[] arrayNew = new int[result];


        for (int i = arrayNew.length-1; i >= 0; i--) {
            arrayNew[i] = num % 2;
            num /= 2;
        }

        System.out.print("[ ");
        for (int i = 0; i < arrayNew.length; i++) {
            System.out.print(arrayNew[i]);
        }
        System.out.println(" ]");


    }
}
