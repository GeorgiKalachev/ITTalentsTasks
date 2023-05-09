package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, която намира и извежда най-дългата редица от
        //еднакви поредни елементи в даден масив.

        int num;
        do{
            System.out.println("How many cells do you need? Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num <=0);
        int[] firstArr = new int[num];

        for (int i = 0; i < firstArr.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            firstArr[i] = sc.nextInt();
        }


        int currNum = 0;
        int count = 1;
        int max = 1;
        for (int i = 1; i < firstArr.length; i++) {
                if (firstArr[i] == firstArr[i - 1]) {
                    if(count >= max){
                        currNum = firstArr[i];
                    }
                    count++;
                }else {
                    if ( count > max){
                        max = count;
                    }
                    count = 1;
                }
        }

        int bigger = (count > max) ? count : max;
        if(bigger > 1){
            System.out.println("You have equal numbers. Number :" + currNum + " repeats " + bigger + " times.");
            for (int i = 1; i <= bigger ; i++) {
                System.out.print((i != bigger) ? currNum + ", " : currNum );
            }
        }else {
            System.out.println("You dont have equal numbers.");
        }


    }
}
