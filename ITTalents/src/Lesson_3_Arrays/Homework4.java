package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се прочете масив и да се отпечата дали е огледален.
        //Следните масиви са огледални:
        //[3 7 7 3]
        //[4]
        //[1 55 1]
        //[6 27 -1 5 7 7 5 -1 27 6]

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

        boolean isEqual = false;
        for (int i = 0; i <= numbers.length / 2; i++) {
            if(numbers[i] == numbers[num-1]){
                isEqual = true;
            }else {
                isEqual = false;
                break;
            }
            num--;
        }

        System.out.println(isEqual ? "Mirror numbers" : "Not mirror numbers");
    }
}
