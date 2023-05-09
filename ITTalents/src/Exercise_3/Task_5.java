package Exercise_3;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int result = 0;
        int multiplayer = 1;

        if (num > 0){

            while (num > 0){

                 int digit = num % 2;

                result = result + digit* multiplayer;

                multiplayer *= 10;
                 num = num / 2;
            }
            System.out.println(result);

        }else {
            System.out.println("Your number is negative.");
        }
    }
}
