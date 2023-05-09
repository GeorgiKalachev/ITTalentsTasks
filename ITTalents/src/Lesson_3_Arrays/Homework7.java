package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, която първо чете масив и после създава нов
        //масив със същия размер по следния начин: стойността на всеки
        //елемент от втория масив да е равна на сбора от предходния и
        //следващият елемент на съответния елемент от първия масив. Първият
        //и последният елемент на втория масив трябва да си останат равни на
        //първият и последният от елемент от първия масив.
        //Да се изведе получения масив.

        int num;
        do{
            System.out.println("How many cells do you need? Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num <=0);
        int[] firstArr = new int[num];
        int[] secArray = new int[num];

        for (int i = 0; i < firstArr.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            firstArr[i] = sc.nextInt();
        }

        secArray[0] = firstArr[0];
        secArray[num-1] = firstArr[num-1];
        for (int i = 1; i < firstArr.length-1; i++) {
            secArray[i] = firstArr[i-1] + firstArr[i+1];
        }

        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < secArray.length; i++) {
            System.out.print((i == secArray.length-1) ? secArray[i] : secArray[i] + ", ");
        }
        System.out.print(" ]");

    }
}
