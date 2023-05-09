package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се прочете масив и да се намери най-малкото число кратно на
        //3 от масива.
        //10, 3, 5, 8, 6, -3, 7
        //Най-малкото число кратно на 3 е -3
        int num;
        do{
            System.out.println("How many cells do you need? Enter number bigger than 0.");
            num = sc.nextInt();
        }while (num <=0);
        int[] numbers = new int[num];

        for (int i = 0; i < numbers.length ; i++) {
            System.out.println("Enter value for cell :" + (i+1));
            numbers[i] = sc.nextInt();
        }


        int currNum = 1;


        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % 3 == 0){
                currNum = numbers[i];
                for (int j = i; j < numbers.length ; j++) {
                    if (numbers[j] % 3 == 0 && numbers[j] < currNum){
                        currNum = numbers[j];
                    }
                }
                break;
            }
        }


        if( currNum != 1) {
            System.out.println("Minimal number divide by 3  is :" + currNum);
        }else {
            System.out.println("Invalid numbers.");
        }



    }
}
