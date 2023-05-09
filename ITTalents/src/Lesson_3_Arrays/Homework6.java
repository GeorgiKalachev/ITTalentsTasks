package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Напишете програма, която първо чете 2 масива и после извежда
        //съобщение дали са еднакви, и дали са с еднакъв размер.

        int lengthFirst;
        do {
            System.out.println("Enter length for first array bigger than 0 :");
            lengthFirst = sc.nextInt();
        }while (lengthFirst <=0);
        int[] firstArr = new int[lengthFirst];

        for (int i = 0; i < firstArr.length ; i++) {
            System.out.println("For first Array, Enter value for cell :" + (i+1));
            firstArr[i] = sc.nextInt();
        }

        int lengthSec;
        do {
            System.out.println("Enter length for second array bigger than 0:");
            lengthSec = sc.nextInt();
        }while (lengthSec <= 0);
        int[] secArr = new int[lengthSec];

        for (int i = 0; i < secArr.length ; i++) {
            System.out.println("For second Array, Enter value for cell :" + (i+1));
            secArr[i] = sc.nextInt();
        }

        int smallerArr = (lengthFirst <= lengthSec) ? lengthFirst : lengthSec;

        boolean areSameArrays = lengthSec == lengthFirst;
        boolean isEqual = false;
        for (int i = 0; i < smallerArr; i++) {
            if (firstArr[i] == secArr[i]){
                isEqual = true;
            }else {
                break;
            }
        }

        if ( areSameArrays && isEqual){
            System.out.println("Arrays are with same length and are equal.");
        } else if (isEqual) {
            System.out.println("Arrays are equal, but not the same size.");
        }else {
            System.out.println("Arrays are not equal.");
        }

    }
}
