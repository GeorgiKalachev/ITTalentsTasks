package Lesson_4_Tasks;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many cells do you need?");
        int num = sc.nextInt();

        while (num <= 1){
            System.out.println("Enter number bigger than 1:");
            num = sc.nextInt();
        }
        int[] arrayNums = new int[num];

        for (int i = 0; i < arrayNums.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            arrayNums[i] = sc.nextInt();
        }


        boolean hasAngle = false;
        for (int i = 1; i < arrayNums.length-1 ; i++) {
            if ( arrayNums[i] > arrayNums[i-1] && arrayNums[i] < arrayNums[i+1] ||
                    arrayNums[i] > arrayNums[i-1] && arrayNums[i] > arrayNums[i+1]){
                hasAngle = true;
            }

        }

        if(hasAngle){
            System.out.println("The array is going in Zig Zag positive way");
        }else {
            System.out.println("Incorrect array.");
        }
    }
}

