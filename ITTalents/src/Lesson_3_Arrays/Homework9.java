package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, в която потребителя въвежда масив, след което
        //елементите на масива се обръщат в обратен ред (Целта не е масива да
        //се отпечата в обратен ред, ами първо да се обърне, след което да се
        //отпечата в нормален ред). Пробвайте да решите задачата първо с един
        //допълнителен масив и после без да използвате друг масив.

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

        for (int i = 0; i < firstArr.length; i++) {
            secArray[--num] = firstArr[i];
        }
        // Втори масив е обърнат.

        System.out.println("First array is flipped and printed original.");
        System.out.print("[ ");
        for (int i = secArray.length-1; i >=0 ; i--) {
            System.out.print((i==0)? secArray[i] : secArray[i] + ", ");
        }
        System.out.println(" ] - with second array.");


        System.out.println("----------------------------------");
        System.out.print("[ ");
        for (int i = 0; i < firstArr.length ; i++) {
            System.out.print((i== firstArr.length-1)? firstArr[i] : firstArr[i] + ", ");
        }
        System.out.println(" ] - with first array.");

        System.out.println("----------------------------------");
        System.out.print("[ ");
        for (int i = firstArr.length-1; i >=0 ; i--) {
            System.out.print((i== 0)? firstArr[i] : firstArr[i] + ", ");
        }
        System.out.println(" ] - first array flipped.");


    }
}
