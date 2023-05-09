package Exercise_3;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Write a program that reads a short positive number and tells how many bits are 1 in it.

        int num = sc.nextInt();
        int count = 0;
        if (num > 0 && num <= 32767 ){

            while (num > 0){

                int digit = num % 2;
                if (digit == 1){
                    count++;
                }

                num = num / 2;
            }

        }else if ( num < 0){
            System.out.println("Your number is negative.");
        } else if ( num >32767) {
            System.out.println("Your number is not Short number.");
        }

        System.out.printf("You number have %d bits of 1 in it.",count );
    }
}
