package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("You have to enter 10 numbers !");
        double[] arrayNum = new double[10];
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.println("Enter value for cell :" + (i + 1));
            arrayNum[i] = sc.nextDouble();
        }
        //Да се състави програма, чрез която предварително въведени 10
        //реални числа от интервала се обработват по следния начин:
        //1. Извежда съществуващите числа.
        //2. Всички елементи със стойност по-малки от -0.231 се заменят със
        //сумата от квадрата на поредния им номер + числото 41.25, а всички
        //останали елементи се заменят с произведението между самия елемент
        //и неговият пореден номер. Поредният номер на първият елемент е 1.
        //3. Да се изведат елементите от началния и новообразувания масив.
        //Пример: -1.12, -2.43, 3.1, 4.2, 0, 6.4, - 7.5, 8.6, 9.1, -4
        //Изход: 42.25, 45.25, 9.3, 16.8, 0, 38.4, 90.25, 68.8, 81.9,141.25

        for (int i = 0; i < arrayNum.length; i++) {
            if (arrayNum[i] < -0.231){
                arrayNum[i] = (i+1) * (i+1) + 41.25;
            }else{
                arrayNum[i] *= i+1;
            }
        }
        System.out.print("[ ");
        for (int i = 0; i < arrayNum.length; i++) {
            System.out.print((i==arrayNum.length-1) ? arrayNum[i] : arrayNum[i] + "; ");
        }
        System.out.print(" ]");
    }
}
