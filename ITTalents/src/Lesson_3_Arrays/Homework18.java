package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number for Arrays length :");
        int num = sc.nextInt();

        while (num < 1){
            System.out.println("Enter number bigger than 0 !!!");
            num = sc.nextInt();
        }
        int[] firstArray = new int[num];
        int[] secArray = new int[num];
        int[] thirdArr = new int[num];

        for (int i = 0; i < firstArray.length; i++) {
            System.out.println("Enter number for First array in cell: " + (i+1));
            firstArray[i] = sc.nextInt();
        }
        System.out.println("Now for the second array.");
        for (int i = 0; i < secArray.length; i++) {
            System.out.println("Enter number for First array in cell: " + (i+1));
            secArray[i] = sc.nextInt();
        }
        //Дадени са два едномерни масива с естествени числа.
        //Да се състави програма, която сравнява всички числа с еднакви
        //индекси от двата масива и записва в трети масив, по-голямото от
        //двете числа.
        //Да се изведе съдържанието и на трите масива
        //Пример:
        //18,19,32,1,3, 4, 5, 6, 7, 8
        //1, 2, 3,4,5,16,17,18,27,11
        //Изход:
        //18,19,32 ,4,5,16,17,18,27,11

        for (int i = 0; i < firstArray.length; i++) {
            thirdArr[i] = (firstArray[i] > secArray[i]) ? firstArray[i] : secArray[i];
        }

        System.out.print("First array [ ");
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print((i==firstArray.length-1) ? firstArray[i] : firstArray[i] + "; ");
        }
        System.out.println(" ]");

        System.out.print("Second array [ ");
        for (int i = 0; i < secArray.length; i++) {
            System.out.print((i==secArray.length-1) ? secArray[i] : secArray[i] + "; ");
        }
        System.out.println(" ]");

        System.out.print("Third array [ ");
        for (int i = 0; i < thirdArr.length; i++) {
            System.out.print((i==thirdArr.length-1) ? thirdArr[i] : thirdArr[i] + "; ");
        }
        System.out.print(" ]");
    }
}
